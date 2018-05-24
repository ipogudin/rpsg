package ipogudin.domain;

import java.util.Arrays;
import java.util.List;

import static ipogudin.domain.Shape.ROCK;
import static ipogudin.domain.Shape.PAPER;
import static ipogudin.domain.Shape.SCISSORS;
import static ipogudin.domain.Result.USER_WON;
import static ipogudin.domain.Result.COMPUTER_WON;

/**
 * Psycological strategy based on https://www.psychologytoday.com/us/blog/the-blame-game/201504/the-surprising-psychology-rock-paper-scissors
 */
public class PsycologicalStrategy extends RandomShapeStrategy {

    private GameResult previousGameResult;
    private final List<Shape> prioritizedShapes = Arrays.asList(ROCK, PAPER, SCISSORS, ROCK);

    @Override
    public Shape showShape() {
        if (previousGameResult == null) {
            //first step
            return super.showShape();
        }
        else if (previousGameResult.getResult() == COMPUTER_WON) {
            int i = prioritizedShapes.indexOf(previousGameResult.getComputerShape());
            return prioritizedShapes.get(i + 1);
        }
        else if (previousGameResult.getResult() == USER_WON) {
            int i = prioritizedShapes.indexOf(previousGameResult.getUserShape());
            return prioritizedShapes.get(i + 1);
        }
        return super.showShape();
    }

    @Override
    public void record(GameResult result) {
        previousGameResult = result;
    }

}