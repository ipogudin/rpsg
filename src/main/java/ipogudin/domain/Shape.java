package ipogudin.domain;

/**
 * A shape in the game.
 */
public enum Shape {

    ROCK("Rock"), PAPER("Paper"), SCISSORS("Scissors");

    String name;

    Shape(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
