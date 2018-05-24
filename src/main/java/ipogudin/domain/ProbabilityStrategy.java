package ipogudin.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

import static ipogudin.domain.Shape.*;

/**
 * Probability strategy takes into account history of user's steps.
 * The idea behind this algorithm to track history of user's shapes and result to predict his next step
 * (a kind of Markov chains).
 */
public class ProbabilityStrategy extends RandomShapeStrategy {

    private final Logger logger = LoggerFactory.getLogger(ProbabilityStrategy.class);

    private final Pattern pattern = new Pattern();
    private final List<Shape> prioritizedShapes = Arrays.asList(ROCK, PAPER, SCISSORS, ROCK);
    private final Map<Pattern, Bucket> statistics = new HashMap<>();

    @Override
    public Shape showShape() {
        logger.trace("Statistics: " + statistics.toString());
        if (!pattern.isReady()) {
            //first steps
            return super.showShape();
        }
        Shape shape = predictUserShape();
        return choosePrioritizedShape(shape);
    }

    @Override
    public void record(GameResult gr) {
        pattern.add(gr.getUserShape(), gr.getResult());
        if (pattern.isReady()) {
            statistics.compute(pattern,
                    (k, bucket) -> Optional.ofNullable(bucket).orElse(new Bucket())
                            .increment(gr.getUserShape()));
        }
    }

    private Shape predictUserShape() {
        return statistics.get(pattern).mostProbableTransition();
    }

    private Shape choosePrioritizedShape(Shape shape) {
        int i = prioritizedShapes.indexOf(shape);
        return prioritizedShapes.get(i + 1);
    }

    /**
     * A bucket with possible target transitions.
     */
    private class Bucket {

        private final Map<Shape, Integer> counters =
                Arrays.stream(
                    Shape.values()).collect(
                    Collectors.toMap(s -> s, e -> 0));

        private Bucket increment(Shape shape) {
            counters.computeIfPresent(shape, (k, v) -> v + 1);
            return this;
        }

        private Shape mostProbableTransition() {
            return
                counters.values().stream().reduce(Integer::max)
                    .flatMap(max -> counters.entrySet().stream()
                            .filter(e -> e.getValue() == max)
                            .map(Map.Entry::getKey).findFirst())
                    .orElseGet(ProbabilityStrategy.super::showShape);
        }

        @Override
        public String toString() {
            return "Bucket{" +
                    "counters=" + counters +
                    '}';
        }
    }

    /**
     * Pattern of previous shapes.
     */
    private class Pattern {

        private final int patternLenght = 2;
        private StringBuilder c = new StringBuilder();
        private Result lastResult;

        private void add(Shape shape, Result result) {
            lastResult = result;
            c.append(shape.toString().substring(0, 1));
            if (c.length() > patternLenght) {
                c.delete(0, c.length() - patternLenght);
            }
        }

        private boolean isReady() {
            return c.length() == patternLenght;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pattern pattern = (Pattern) o;
            return Objects.equals(c.toString(), pattern.c.toString()) &&
                    lastResult == pattern.lastResult;
        }

        @Override
        public int hashCode() {

            return Objects.hash(c.toString(), lastResult);
        }

        @Override
        public String toString() {
            return "Pattern{" +
                    "patternLenght=" + patternLenght +
                    ", c=" + c +
                    ", lastResult=" + lastResult +
                    '}';
        }
    }
}