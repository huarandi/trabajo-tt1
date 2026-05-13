package logic;

import model.Board;

/**
 * Esta interfaz define la clase base de la ejecucion de la simulacíon
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
public interface InterfaceSimulator
{
    /**
     * Constructor de la clase que genera el estado inicial de la simulacion
     */
    public Board simulate(Board b0);
}


