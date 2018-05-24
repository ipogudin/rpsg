package ipogudin.domain;

/**
 * Game strategy.
 */
public interface Strategy {

    /**
     * @return a shape according to game strategy.
     */
    Shape showShape();

    /**
     * Records a previous result. Must be called after {@link #showShape()}.
     * @param result
     */
    void record(GameResult result);
}
