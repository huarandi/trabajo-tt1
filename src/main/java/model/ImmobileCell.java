package model;

import logic.SimIterator;

import java.util.List;

/**
 * Esta clase define uno de los tipos de objeto base de la simulacion, es decir la una de las piezas que se movera en el tablero de la simulacion,
 * en concreto la pieza inmovil que no cambia de posicion a lo largo de la simulacion
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
public class ImmobileCell extends Cell
{
    /**
     * Método que transforma el objeto de la clase en un String
     * @return  String con los datos del objeto de la clase
     */
    @Override
    public String toString()
    {
        return "010";
    }

    /**
     * Método que genera los cambios que quiere realizar la celula inmovil en el siguiente instante
     * @param it Numero de filas que tendra el tablero de la simulacion
     * @return Devuelve
     */
    @Override
    public List<BoardChange> iterate(SimIterator it) {
        return it.iterativeInmobile(this);
    }

    /**
     * Metodo que devuelve el color de la celula
     * @return Devuelve un string con el color de la celula
     */
    @Override
    public String getColor() {
        return "red";
    }
}
