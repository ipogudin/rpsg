package ipogudin.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicStatisticsAggregator implements StatisticsAggregator {

    private final Map<Result, Integer> results = Arrays.asList(Result.values()).stream()
            .collect(Collectors.toMap(Function.identity(), e -> 0));

    public void aggregate(GameResult gr) {
        results.computeIfPresent(gr.getResult(), (k, v) -> v + 1);
    }

    @Override
    public Map<Result, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }

}
