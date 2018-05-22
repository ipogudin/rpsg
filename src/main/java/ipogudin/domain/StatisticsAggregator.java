package ipogudin.domain;

import java.util.Map;

public interface StatisticsAggregator {

    void aggregate(GameResult gameResult);

    Map<Result, Integer> getResults();
}
