package ipogudin.domain;

import ipogudin.domain.config.GameProcessorWithProbabilityStrategy;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Import(GameProcessorWithProbabilityStrategy.class)
public class GameProcessorWithProbabilityStrategyTest extends RuleValidationTest{

    @Autowired
    private GameProcessor gameProcessor;

    @Override
    protected GameProcessor gameProcessor() {
        return gameProcessor;
    }
}
