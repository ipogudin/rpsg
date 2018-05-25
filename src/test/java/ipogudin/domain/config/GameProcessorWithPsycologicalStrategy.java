package ipogudin.domain.config;

import ipogudin.GameConfiguration;
import ipogudin.domain.PsycologicalStrategy;
import ipogudin.domain.Strategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfiguration.class)
public class GameProcessorWithPsycologicalStrategy {

    @Bean
    public Strategy strategy() {
        return new PsycologicalStrategy();
    }

}
