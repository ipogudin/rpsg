package ipogudin;

import ipogudin.domain.BasicStatisticsAggregator;
import ipogudin.domain.GameProcessor;
import ipogudin.domain.ClassicGameProcessor;
import ipogudin.domain.StatisticsAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    public GameProcessor gameProcessor() {
        return new ClassicGameProcessor();
    }

    @Bean
    public StatisticsAggregator statisticsAggregator() {
        return new BasicStatisticsAggregator();
    }
}
