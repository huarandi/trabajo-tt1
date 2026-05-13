package model;

import logic.SimIterator;

import java.util.List;

/**
 * Esta clase define el objeto base de la simulacion, es decir la pieza que se movera en el tablero de la simulacion
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
public abstract class Cell
{
    /**
     * Método que genera el los cambios en el tablero de la simulaicon en un instante
     * @return Devuelve un String con el objeto de la clase
     */
    public abstract String toString();

    /**
     * Método que genera los cambios que quiere realizar la celula en el siguiente instante
     * @param it Numero de filas que tendra el tablero de la simulacion
     * @return Devuelve
     */
    public abstract List<BoardChange> iterate(SimIterator it);
}
