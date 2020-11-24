package domain;

public class CellAStarCosts {
    private int hCost;
    private int gCost;

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


}
