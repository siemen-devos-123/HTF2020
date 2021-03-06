package domain.maze;

import domain.maze.cell.Cell;
import domain.maze.cell.CellFactory;
import domain.maze.cell.Walls;
import io.vertx.core.json.JsonObject;

public class MazeFactory {

    private CellFactory cellFactory;

    public MazeFactory() {
        cellFactory = new CellFactory();
    }

    public Maze create(JsonObject maze){
        Maze res = new Maze(maze.getString("mazeId"));

        maze.getJsonArray("cells")
                .stream()
                .map((json) -> { return createCell((JsonObject) json); })
                .forEach((cell) -> {res.addCell((Cell) cell);});

        res.getCells().get(res.getCells().size() - 1).getWalls().add(Walls.SOUTH);

        return res;
    }

    private Cell createCell(JsonObject cell){
        return cellFactory.create(cell);
    }
}
