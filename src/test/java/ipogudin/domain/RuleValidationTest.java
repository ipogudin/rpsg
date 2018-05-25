package ipogudin.domain;

import org.junit.Test;

import static ipogudin.domain.Shape.PAPER;
import static ipogudin.domain.Shape.ROCK;
import static ipogudin.domain.Shape.SCISSORS;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class RuleValidationTest {

    protected abstract GameProcessor gameProcessor();

    @Test
    public void processingValidGame() {
        GameResult gr = gameProcessor().process(ROCK);
        assertThat(gr.getResult()).isNotNull();
        assertThat(gr.getUserShape()).isNotNull();
        assertThat(gr.getUserShape()).isEqualTo(ROCK);
        assertThat(gr.getComputerShape()).isNotNull();
    }

    @Test
    public void validationRulesForRock() {
        GameResult gr = gameProcessor().process(ROCK);
        if (gr.getComputerShape() == ROCK) {
            assertThat(gr.getResult()).isEqualTo(Result.DRAW);
        }
        else if (gr.getComputerShape() == PAPER) {
            assertThat(gr.getResult()).isEqualTo(Result.COMPUTER_WON);
        }
        else if (gr.getComputerShape() == SCISSORS) {
            assertThat(gr.getResult()).isEqualTo(Result.USER_WON);
        }
    }

    @Test
    public void validationRulesForPaper() {
        GameResult gr = gameProcessor().process(PAPER);
        if (gr.getComputerShape() == ROCK) {
            assertThat(gr.getResult()).isEqualTo(Result.USER_WON);
        }
        else if (gr.getComputerShape() == PAPER) {
            assertThat(gr.getResult()).isEqualTo(Result.DRAW);
        }
        else if (gr.getComputerShape() == SCISSORS) {
            assertThat(gr.getResult()).isEqualTo(Result.COMPUTER_WON);
        }
    }

    @Test
    public void validationRulesForScissors() {
        GameResult gr = gameProcessor().process(SCISSORS);
        if (gr.getComputerShape() == ROCK) {
            assertThat(gr.getResult()).isEqualTo(Result.COMPUTER_WON);
        }
        else if (gr.getComputerShape() == PAPER) {
            assertThat(gr.getResult()).isEqualTo(Result.USER_WON);
        }
        else if (gr.getComputerShape() == SCISSORS) {
            assertThat(gr.getResult()).isEqualTo(Result.DRAW);
        }
    }

}
