package domain;

import domain.maze.cell.Cell;

public class CellAStarCosts implements Comparable<CellAStarCosts> {
    private int hCost;
    private int gCost;
    private boolean visited;

    public CellAStarCosts(int hCost, int gCost) {
        this.hCost = hCost; //distance to end
        this.gCost = gCost; //distance from start
    }

    public int gethCost() {
        return hCost;
    }

    public int getgCost() {
        return gCost;
    }

    public void setgCost(int gCost) {

        this.gCost = gCost;
    }

    public int getfCost(){
        return gethCost() + getgCost();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "CellAStarCosts{" +
                "hCost=" + hCost +
                ", gCost=" + gCost +
                ", fCost=" + getfCost() +
                '}';
    }

    @Override
    public int compareTo(CellAStarCosts o) {
        return o.getfCost() - this.getfCost();
    }
}
