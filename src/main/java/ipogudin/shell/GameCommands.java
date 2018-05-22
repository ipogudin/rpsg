package ipogudin.shell;

import ipogudin.domain.GameProcessor;
import ipogudin.domain.GameResult;
import ipogudin.domain.Shape;
import ipogudin.domain.StatisticsAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@ShellComponent
public class GameCommands {

    private final Map<String, Shape> shapes =
            Arrays.asList(Shape.values()).stream()
                    .collect(Collectors.toMap(shape -> shape.toString().toLowerCase(), Function.identity()));

    @Autowired
    private GameProcessor gameProcessor;

    @Autowired
    private StatisticsAggregator statisticsAggregator;

    @ShellMethod("Plays a game. You should set your shape as a parameterplay.")
    public String play(@ShellOption(help = "Value must be one from: rock, paper, scissors") String shape) {
        Optional<Shape> userShape = Optional.ofNullable(shapes.get(shape.toLowerCase()));
        GameResult gr = gameProcessor.process(
                userShape.orElseThrow(() -> new RuntimeException("Wrong command value.")));
        statisticsAggregator.aggregate(gr);
        return String.format("Computer showed %s\nYou showed %s\nThe result is %s",
                gr.getComputerShape(), gr.getUserShape(), gr.getResult());
    }

    @ShellMethod("Shows statistics of all previous games.")
    public String stat() {
        return statisticsAggregator.getResults().entrySet().stream()
                .map(k -> String.format("%s: %d times", k.getKey().toString(), k.getValue()))
                .collect(Collectors.joining( "\n" ));
    }
}
