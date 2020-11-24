package domain.maze.cell;

import domain.Challenge;
import domain.Position;
import domain.maze.Maze;
import io.vertx.core.json.JsonObject;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CellFactory {
    public Cell create(JsonObject cell){
        Cell res = new Cell(
                getPosition(cell),
                getWalls(cell)
        );
        if(cell.getBoolean("decisionPoint")){
            res.setChallenge(
                    getChallenge(cell)
            );
        }

        if(res.getPosition().equals(new Position(0, 0))){
            res.getWalls().add(Walls.NORTH);
        }


        return res;
    }



    private Position getPosition(JsonObject cell) {
        return new Position(
                cell.getInteger("x"),
                cell.getInteger("y")
        );
    }

    private Set<Walls> getWalls(JsonObject cell){
        Set<Walls> res = cell.getJsonArray("sides")
                .stream()
                .map((wallString) -> { return Walls.valueOf((String) wallString); })
                .collect(Collectors.toSet());

        return res;
    }

    private Challenge getChallenge(JsonObject cell) {
        return new Challenge(
                cell.getString("challengeId"),
                cell.getString("challenge"),
                cell.getString("challengeParameters")
        );
    }
}
