package server;

import model.Game;

public interface RequestManager {
    public int requestSimulation(RequestData requestData);
    public boolean hasEnded(int token);
    public Game getResults(int token);
}
