package ipogudin;

import ipogudin.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    public GameProcessor gameProcessor() {
        return new ClassicGameProcessorCyclicAlgo();
    }

    @Bean
    public StatisticsAggregator statisticsAggregator() {
        return new BasicStatisticsAggregator();
    }
}
