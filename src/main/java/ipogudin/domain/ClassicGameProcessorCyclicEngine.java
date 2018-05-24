package ipogudin.domain;


import java.util.Arrays;
import java.util.List;

import static ipogudin.domain.Result.COMPUTER_WON;
import static ipogudin.domain.Result.DRAW;
import static ipogudin.domain.Result.USER_WON;
import static ipogudin.domain.Shape.PAPER;
import static ipogudin.domain.Shape.ROCK;
import static ipogudin.domain.Shape.SCISSORS;

public class ClassicGameProcessorCyclicEngine extends ClassicGameProcessor {

    //rules should contain a list of shapes. A shape with the highest position wins
    // with exception that the first shape beats the last on.
    private final List<Shape> rules = Arrays.asList(ROCK, PAPER, SCISSORS);

    public ClassicGameProcessorCyclicEngine(Strategy strategy) {
        super(strategy);
    }

    @Override
    protected Result play(Shape userShape, Shape computerShape) {
        int ui = rules.indexOf(userShape);
        int ci = rules.indexOf(computerShape);
        if (ui == ci) {
            return DRAW;
        }
        else if ((ui == ci - 1) || (ci == 0 && ui == (rules.size() -1))) {
            return COMPUTER_WON;
        }
        return USER_WON;
    }

}
