package ui.api;

import domain.maze.Maze;
import domain.maze.MazeFactory;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

public class Start {
    private static final String TEAM_ID = "d8c55a8b-72bd-4521-8626-ccf2c2ee1445";

    public static void main(String[] args) {
        new Start().run();
    }

    private void run(){
        System.out.println("hi");

        WebClient client = WebClient.create(Vertx.vertx());
        MazeFactory factory = new MazeFactory();

        client
            .get( "maze-staging.bewire.org", "/maze")
            .addQueryParam("teamId", TEAM_ID)
            .send(ar -> {
                if(ar.succeeded()){
                    HttpResponse<Buffer> response = ar.result();
                    Maze maze = factory.create(response.bodyAsJsonObject());
                    System.out.println(maze.getEndPosition());
                }
            });
    }
}
