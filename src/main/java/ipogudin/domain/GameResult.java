package ipogudin.domain;

/**
 * Just a container with game result.
 */
public class GameResult {

    private final Result result;
    private final Shape userShape;
    private final Shape computerShape;

    private GameResult(Result result, Shape userShape, Shape computerShape) {
        this.result = result;
        this.userShape = userShape;
        this.computerShape = computerShape;
    }

    public Result getResult() {
        return result;
    }

    public Shape getUserShape() {
        return userShape;
    }

    public Shape getComputerShape() {
        return computerShape;
    }

    public static GameResult create(Result result, Shape userShape, Shape computerShape) {
        return new GameResult(result, userShape, computerShape);
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "result=" + result +
                ", userShape=" + userShape +
                ", computerShape=" + computerShape +
                '}';
    }
}
