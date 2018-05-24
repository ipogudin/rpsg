package ipogudin.domain;

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

    private final Strategy strategy;

    public ClassicGameProcessor(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public GameResult process(Shape userShape) {
        Shape computerShape = strategy.showShape();
        Result r = play(userShape, computerShape);
        GameResult gr = GameResult.create(r, userShape, computerShape);
        strategy.record(gr);
        return gr;
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
