package server;

import logic.Simulator;
import model.Game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/**
 * Esta clase define el almacen de tokens y simulaciones del servidor
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
public class GameTokens {

    private static GameTokens gameTokens;
    private Map<Integer, Future<Game>> table;

    /**
     * Constructor de la clase que genera el almacen de tokens y simulaciones
     */
    private GameTokens(){
        table=new ConcurrentHashMap<>();
    }

    /**
     * Metodo estatico que aplica el patron singleton para devolver la instancia actual del almacen de tokens y simulaciones
     * @return Devuelve una instancia actual del almacen
     */
    public static GameTokens getInstance(){
        if(gameTokens==null){
            gameTokens=new GameTokens();
        }
            return gameTokens;
    }

    /**
     * Metodo que añade un par token y simulacion al almacen
     * @param token Identificador unico de la simulacion
     * @param game Simulacion realizada a partir de una peticion del cliente
     */
    public void addGame(int token, Future<Game> game){
        table.put(token, game);
    }

    /**
     * Metodo que devuelve la simulacion del par token/simulacion del almacen a partir de un token
     * @param token Identificador unico de la simulacion
     * @return
     */
    public Future<Game> getGame(int token){
        return table.get(token);
    }

    /**
     * Metodo que comprueba la simulacion del par token/simulacion del almacen a partir de un token
     * @param token Identificador unico de la simulacion
     * @return Devuelve verdadero si hay una simulacion asignada al token pasado como parametro en el almacen
     */
    public boolean hasGame(int token){
        return table.containsKey(token);
    }

    /**
     * Metodo que elimina la simulacion del par token/simulacion del almacen a partir de un token
     * @param token Identificador unico de la simulacion
     */
    public void removeGame(int token){
        table.remove(token);
    }
}
