package domain.maze;

import domain.Position;
import domain.maze.cell.Cell;

import java.util.LinkedList;
import java.util.List;

public class Maze {
    private String id;
    private List<Cell> cells;

    public Maze(String mazeId) {
        this.id = mazeId;
        this.cells = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void addCell(Cell cell){
        cells.add(cell);
    }

    public List<Cell> getCells() {
        return List.copyOf(cells);
    }

    public Cell getCellByPosition(Position position){
        Cell res = null;
        for(Cell cell : getCells()){
            if(cell.getPosition().equals(position)){
                res = cell;
            }
        }

        return res;
    }

    public Position getEndPosition(){
        return getCells().get(getCells().size() - 1).getPosition();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("%s%n", getId()));

        for (Cell cell : getCells()){
            res.append(String.format("%s%n", cell));
        }

        return res.toString();
    }
}
