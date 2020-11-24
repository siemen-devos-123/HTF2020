package domain;

import java.io.Serializable;
import java.util.List;

public class Solution implements Serializable {
    private List<Position> cells;

    public Solution(List<Position> cells) {
        this.cells = cells;
    }

    public List<Position> getCells() {
        return cells;
    }
}
