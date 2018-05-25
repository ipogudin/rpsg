package ipogudin.domain.config;

import ipogudin.GameConfiguration;
import ipogudin.domain.ProbabilityStrategy;
import ipogudin.domain.Strategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfiguration.class)
public class GameProcessorWithProbabilityStrategy {

    @Bean
    public Strategy strategy() {
        return new ProbabilityStrategy();
    }

}
