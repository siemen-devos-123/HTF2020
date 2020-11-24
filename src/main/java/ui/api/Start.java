package ui.api;

import domain.Challenge;
import domain.ChallengeSolver;
import domain.maze.Maze;
import domain.maze.MazeFactory;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

import java.util.HashMap;

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

        Challenge challenge = new Challenge("1", "this", "this");
        ChallengeSolver solver = new ChallengeSolver(challenge);

        System.out.println(solver.Convert2HexaDecimal("JEma7vgs911"));
        System.out.println(solver.findAllPrimes(19098, 19198));
        HashMap hashMap = new HashMap();
        hashMap.put("1", "ont");
        hashMap.put("2", "7qXo");
        hashMap.put("3", "bAn");
        hashMap.put("4", "eH1");
        hashMap.put("5", "dxC");
        System.out.println(solver.getElementOfHashmap("2", hashMap));
        System.out.println(solver.isInAlphabeticOrder("bHF47ubG2Xx8AgtnRsa4qBSWykTZfJfAoce8Ax9gF67AjGQNTFCPuu5zgqShxtxIn9hRjGCcwJO6Wl8r55dbHE5avEQ1v5qXL0dmemMVJSLE"));
    }
}
