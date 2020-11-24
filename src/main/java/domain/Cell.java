package domain;

public class Cell {
    private Position position;
    private Challenge challenge;

    public Cell(Position position, Challenge challenge) {
        this.position = position;
        this.challenge = challenge;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
