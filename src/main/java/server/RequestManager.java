package server;

import model.Game;

import java.util.concurrent.ExecutionException;

public interface RequestManager {
    public int requestSimulation(RequestData requestData);
    public boolean hasEnded(int token);
    public Game getResults(int token) throws ExecutionException, InterruptedException;
}
