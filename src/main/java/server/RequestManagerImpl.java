package server;

import model.Board;
import model.Game;

import java.util.Random;

public class RequestManagerImpl implements RequestManager{
    public int requestSimulation(RequestData requestData){

        Game game=new Game();

        int numStatic=requestData.getCells().get("static");
        int numDynamic=requestData.getCells().get("dynamic");
        int numReproductive=requestData.getCells().get("reproductive");

        Random random=new Random();
        int tmax=numDynamic*numReproductive*numStatic;


        Board board=new Board(tmax, tmax);
        for(int i=0;i<numStatic;i++){

        }
        

        return 0;
    }
    public boolean hasEnded(int token){
        return true;
    }
    public Game getResults(int token){
        return null;
    }
}
