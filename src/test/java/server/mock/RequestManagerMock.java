package server.mock;

import model.Board;
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
        Game g = null;
        if(token == 0){
            g = new Game(0);
        }
        else if(token == 1){
            g= new Game(1);
            Board b1 = new Board(2, 2);
        }

        return g;
    }
}
