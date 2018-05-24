package ipogudin;

import ipogudin.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    public Strategy strategy() {
        return new ProbabilityStrategy();
    }

    @Bean
    public GameProcessor gameProcessor(Strategy strategy) {
        return new ClassicGameProcessorCyclicEngine(strategy);
    }

    @Bean
    public StatisticsAggregator statisticsAggregator() {
        return new BasicStatisticsAggregator();
    }
}
