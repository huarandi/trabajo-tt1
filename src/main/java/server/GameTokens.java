package server;

import logic.Simulator;
import model.Game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameTokens {

    private static Map<Integer, Game> table=new ConcurrentHashMap<Integer, Game>();

    public GameTokens(){
        table=new ConcurrentHashMap<>();
    }

    public void addGame(int token, Game game){
        table.put(token, game);
    }

    public Game getGame(int token){
        return table.get(token);
    }

    public void removeGame(int token){
        table.remove(token);
    }

    public boolean checkGame(int token){
        return table.containsKey(token);
    }

    public static Map<Integer, Game> getTable() {
        return table;
    }

    public static void setTable(Map<Integer, Game> table) {
        GameTokens.table = table;
    }
}
