package server.mock;

import model.Game;
import server.RequestData;
import server.RequestManager;

public class RequestManagerMock implements RequestManager {
    private boolean ended;

    public RequestManagerMock(boolean ended) {
        this.ended = ended;
    }

    @Override
    public int requestSimulation(RequestData requestData) {
        return 10;
    }

    @Override
    public boolean hasEnded(int token) {
        return ended;
    }

    @Override
    public Game getResults(int token) {
        return null;
    }
}
