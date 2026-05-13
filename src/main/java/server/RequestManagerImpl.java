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

/**
 * Esta clase implementa la interfaz que define la clase que  gestionara las peticiones del servidor
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
@Singleton
public class RequestManagerImpl implements RequestManager{
    private GameTokens gameTokens = GameTokens.getInstance();
    private Random random = new Random();
    private ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * Metodo que solicita la ejecucion de una simulacion al servidor
     * @param requestData
     */
    public int requestSimulation(RequestData requestData)
    {
        int token;
        while(gameTokens.hasGame(token = random.nextInt())){}
        Future<Game> game = executor.submit(new ThreadGame(requestData));
        gameTokens.addGame(token, game);
        return token;
    }

    /**
     * Metodo que comprueba si se ha finalizado la ejecucion de una simulacion
     * @return Devuelve verdadero si ha finalizado la ejecucion de la simulacion y falso en caso contrario
     */
    public boolean hasEnded(int token){
        if(!gameTokens.hasGame(token)) return false;
        return gameTokens.getGame(token).isDone();
    }

    /**
     * Metodo que devuelve la simulacion asociada al token pasado como parametro
     * @param token Identificador unico de la simulacion
     * @return Devuelve la simulacion asociada al token
     */
    public Game getResults(int token) throws ExecutionException, InterruptedException {
        if(hasEnded(token)) return gameTokens.getGame(token).get();
        return null;
    }
}
