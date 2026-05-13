package server;

import jakarta.inject.Singleton;
import logic.CellPrioritizer;
import logic.SimIterator;
import logic.Simulator;
import model.*;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Singleton
public class RequestManagerImpl implements RequestManager{
    private GameTokens gameTokens = GameTokens.getInstance();
    private Random random = new Random();
    private ExecutorService executor = Executors.newCachedThreadPool();

    public int requestSimulation(RequestData requestData)
    {
        int token;
        while(gameTokens.hasGame(token = random.nextInt())){}
        Future<Game> game = executor.submit(new ThreadGame(requestData));
        gameTokens.addGame(token, game);
        return token;
    }
    public boolean hasEnded(int token){
        if(!gameTokens.hasGame(token)) return false;
        return gameTokens.getGame(token).isDone();
    }
    
    public Game getResults(int token) throws ExecutionException, InterruptedException {
        if(hasEnded(token)) return gameTokens.getGame(token).get();
        return null;
    }
}
