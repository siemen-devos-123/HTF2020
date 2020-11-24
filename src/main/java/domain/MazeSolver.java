package domain;

import domain.maze.Maze;

public class MazeSolver {

    private Maze maze;
    private Position currentPosition;

    public MazeSolver(Maze maze) {
        this.maze = maze;
        setCurrentPosition(new Position(0,0 ));
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void solve(){

    }


}
