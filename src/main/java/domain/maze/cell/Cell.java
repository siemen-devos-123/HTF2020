package domain.maze.cell;

import domain.Challenge;
import domain.Position;

import java.util.Set;

public class Cell {
    private Position position;
    private Challenge challenge;
    private Set<Walls> walls;

    public Cell(Position position, Set<Walls> walls) {
        this(position, null, walls);
    }

    public Cell(Position position, Challenge challenge, Set<Walls> walls) {
        this.position = position;
        this.challenge = challenge;
        this.walls = walls;
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

    public Set<Walls> getWalls() {
        return walls;
    }

    public void setWalls(Set<Walls> walls) {
        this.walls = walls;
    }

    @Override
    public String toString() {
        return String.format("%s %s, challenge %s", getPosition(), getWalls(), getChallenge());
    }
}
