package domain;

import domain.maze.Maze;
import domain.maze.cell.Cell;
import domain.maze.cell.Walls;

import java.util.*;
import java.util.stream.Collectors;

public class MazeSolver {

    private Maze maze;
    private Position currentPosition;
    private Map<Cell, CellAStarCosts> cells;
    private Position endPosition;

    public MazeSolver(Maze maze) {
        this.maze = maze;
        this.cells = new HashMap<>();
        setCurrentPosition(new Position(0,0 ));
        endPosition = maze.getEndPosition();
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public List<Position> solve(){
        while(! currentPosition.equals(endPosition)){
            calculateNeighbors();
            nextCurrentPosition();
        }

        List<Position> path = new LinkedList<>();
        while(! currentPosition.equals(new Position(0, 0))){

            Cell currentCell = maze.getCellByPosition(currentPosition);
            path.add(currentPosition);

            List<Position> possibleSteps = new LinkedList<>();
            if(!currentCell.getWalls().contains(Walls.NORTH)){

                possibleSteps.add(new Position(currentPosition.getX(), currentPosition.getY() - 1));
            }
            if(!currentCell.getWalls().contains(Walls.EAST)){
                possibleSteps.add(new Position(currentPosition.getX() + 1, currentPosition.getY()));
            }
            if(!currentCell.getWalls().contains(Walls.SOUTH)){
                possibleSteps.add(new Position(currentPosition.getX(), currentPosition.getY() + 1));
            }
            if(!currentCell.getWalls().contains(Walls.WEST)){
                possibleSteps.add(new Position(currentPosition.getX() - 1, currentPosition.getY()));
            }



            Cell min = maze.getCellByPosition(possibleSteps.get(0));
            for (Position step : possibleSteps){
                Cell cell = maze.getCellByPosition(step);
                if(cells.containsKey(cell) && !path.contains(step)){
                    if(cells.get(min).getfCost() > cells.get(cell).getfCost()){
                        min = cell;
                    }
                }

            }
            currentPosition = min.getPosition();
        }

        path.add(new Position(0,0));

        Collections.reverse(path);

        return path;

    }

    public void calculateNeighbors(){
        Cell cell = maze.getCellByPosition(currentPosition);

        if(!cells.containsKey(cell)){
            CellAStarCosts costs = new CellAStarCosts(
                    pythagoras(endPosition.getX() - currentPosition.getX(), endPosition.getY() - currentPosition.getY()),
                    0
            );
            cells.put(cell, costs);
        }
        cells.get(cell).setVisited(true);

        if(!cell.getWalls().contains(Walls.NORTH)){
            calculateNextCell(cell, new Position(currentPosition.getX(), currentPosition.getY() - 1));
        }
        if(!cell.getWalls().contains(Walls.EAST)){
            calculateNextCell(cell, new Position(currentPosition.getX() + 1, currentPosition.getY()));
        }
        if(!cell.getWalls().contains(Walls.SOUTH)){
            calculateNextCell(cell, new Position(currentPosition.getX(), currentPosition.getY() + 1));
        }
        if(!cell.getWalls().contains(Walls.WEST)){
            calculateNextCell(cell, new Position(currentPosition.getX() - 1, currentPosition.getY()));
        }

    }

    public void calculateNextCell(Cell current, Position next){


        Cell nCell = maze.getCellByPosition(next);
        if(!cells.containsKey(nCell)){
            cells.put(nCell, new CellAStarCosts(
                    pythagoras((endPosition.getX() - currentPosition.getX())*10, (endPosition.getY() - currentPosition.getY())*10),
                    cells.get(current).getgCost() + 10
            ));
        }
        else {
            CellAStarCosts cost = cells.get(nCell);
            cost.setgCost(Math.min(cells.get(current).getgCost() + 10, cost.getgCost()));
        }
    }

    public void nextCurrentPosition(){
        List<Map.Entry<Cell, CellAStarCosts>> entries = cells.entrySet().stream()
                .filter(entry -> !entry.getValue().isVisited())
                .collect(Collectors.toList());

        Map.Entry<Cell, CellAStarCosts> min = entries.get(0);
        for(Map.Entry<Cell, CellAStarCosts> entry : entries){
            if(min.getValue().getfCost() > entry.getValue().getfCost()){
                min = entry;
            }
        }

        currentPosition = min.getKey().getPosition();
    }

    public int pythagoras(int a, int b){
        return (int) Math.round(Math.sqrt((a * a) + (b * b)));
    }


}
