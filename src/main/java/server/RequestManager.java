package server;

import model.Game;

import java.util.concurrent.ExecutionException;

/**
 * Esta interfaz define la clase que  gestionara las peticiones del servidor
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
public interface RequestManager {
    /**
     * Metodo que solicita la ejecucion de una simulacion al servidor
     * @param requestData
     */
    public int requestSimulation(RequestData requestData);
    /**
     * Metodo que comprueba si se ha finalizado la ejecucion de una simulacion
     * @return Devuelve verdadero si ha finalizado la ejecucion de la simulacion y falso en caso contrario
     */
    public boolean hasEnded(int token);
    /**
     * Metodo que devuelve la simulacion asociada al token pasado como parametro
     * @param token Identificador unico de la simulacion
     * @return Devuelve la simulacion asociada al token
     */
    public Game getResults(int token) throws ExecutionException, InterruptedException;
}
