package ipogudin.domain;

public enum Result {

    DRAW("Draw"), USER_WON("User won"), COMPUTER_WON("Computer won");

    String name;

    private Result(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
