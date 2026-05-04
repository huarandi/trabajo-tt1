package server;

import logic.Simulator;
import model.Game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameTokens {

    private static GameTokens gameTokens;
    private Map<Integer, Game> table;

    private GameTokens(){
        table=new ConcurrentHashMap<>();
    }

    public static GameTokens getInstance(){
        if(gameTokens==null){
            gameTokens=new GameTokens();
        }
            return gameTokens;
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
}
