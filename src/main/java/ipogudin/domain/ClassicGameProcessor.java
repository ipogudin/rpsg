package ipogudin.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static ipogudin.domain.Shape.ROCK;
import static ipogudin.domain.Shape.PAPER;
import static ipogudin.domain.Shape.SCISSORS;
import static ipogudin.domain.Result.DRAW;
import static ipogudin.domain.Result.USER_WON;
import static ipogudin.domain.Result.COMPUTER_WON;

/**
 * Classic rules of rock, paper, scissors game.
 */
public class ClassicGameProcessor implements GameProcessor {

    private final List<Shape> rules = Arrays.asList(ROCK, PAPER, SCISSORS, ROCK);
    private final Random rand = new Random();

    @Override
    public GameResult process(Shape userShape) {
        Shape computerShape = randomShape();
        Result r = play(userShape, computerShape);
        return GameResult.create(r, userShape, computerShape);
    }

    protected Shape randomShape() {
        return Shape.values()[rand.nextInt(Shape.values().length)];
    }

    protected Result play(Shape userShape, Shape computerShape) throws RuntimeException {
        //Simple implementation with hardcoded rules. The goal of hardcoding rules is to simplify reading and understanding.
        //Less readable implementation could be done with a two dimensional data structure (an array or hashmap of hashmaps)
        //where I could put rules.
        if (userShape == ROCK) {
            if (computerShape == ROCK) {
                return DRAW;
            }
            else if (computerShape == PAPER) {
                return COMPUTER_WON;
            }
            else if (computerShape == SCISSORS) {
                return USER_WON;
            }
        }
        else if (userShape == PAPER) {
            if (computerShape == ROCK) {
                return USER_WON;
            }
            else if (computerShape == PAPER) {
                return DRAW;
            }
            else if (computerShape == SCISSORS) {
                return COMPUTER_WON;
            }
        }
        else if (userShape == SCISSORS) {
            if (computerShape == ROCK) {
                return COMPUTER_WON;
            }
            else if (computerShape == PAPER) {
                return USER_WON;
            }
            else if (computerShape == SCISSORS) {
                return DRAW;
            }
        }
        throw new RuntimeException("This exception must never be thrown.");
    }
}
