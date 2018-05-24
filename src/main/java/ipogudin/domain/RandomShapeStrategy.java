package ipogudin.domain;

import java.util.Random;

public class RandomShapeStrategy implements Strategy {

    private final Random rand = new Random();

    @Override
    public Shape showShape() {
        return Shape.values()[rand.nextInt(Shape.values().length)];
    }

    @Override
    public void record(GameResult result) {
        //ignore any information about a previous result
    }

}
