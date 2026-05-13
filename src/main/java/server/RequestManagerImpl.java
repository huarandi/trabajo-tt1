package server;

import jakarta.inject.Singleton;
import model.*;

import java.util.Random;

@Singleton
public class RequestManagerImpl implements RequestManager{
    private GameTokens gameTokens = GameTokens.getInstance();
    private Random random = new Random();

    public int requestSimulation(RequestData requestData)
    {
        return 0;
    }
    public boolean hasEnded(int token){
        return true;
    }
    public Game getResults(int token){
        return null;
    }
}
