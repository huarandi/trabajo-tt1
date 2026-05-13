package server;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase almacenara la traduccion de los datos recibidos por la peticion para su uso en la simulacion
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
public class RequestData {
    private Map<String,Integer>  cells=new HashMap<String,Integer>();

    /**
     * Constructor de la clase que asigna los datos de la peticion recibidos al map de la clase
     * @param cellsData
     */
    RequestData(Map<String,Integer> cellsData){
        this.cells=cellsData;
    }

    /**
     * Metodo que devuelve el map de la clase
     * @return Map de la clase con los datos de la peticion
     */
    public Map<String, Integer> getCells() {
        return cells;
    }

    /**
     * Metodo que asigna el valor pasado al map de la clase
     */
    public void setCells(Map<String, Integer> cells) {
        this.cells = cells;
    }
}
