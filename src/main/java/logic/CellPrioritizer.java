package logic;

import model.Cell;
import model.ImmobileCell;
import model.MobileCell;
import model.ReproductiveCell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase define las reglas de prioridad que tendran las piezas en la simulacion en cada turno
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
public class CellPrioritizer {
    private int firstPrio = 0;

    private int actualPrio;

    private List<Cell> hadPrio = new ArrayList<>();

    private Map<Class<?>, Integer> prio = new HashMap<>();

    /**
     * Constructor de la clase que genera el estado inicial de las prioridades en la simulacion
     */
    public CellPrioritizer() {
        prio.put(ImmobileCell.class, 0);
        prio.put(MobileCell.class, 1);
        prio.put(ReproductiveCell.class, 2);

        actualPrio = 0;
    }

    /**
     * Metodo que avanza en el map de prio
     * @return x Devuelve verdadero si se avanza en el map de prio y falso en caso contrario
     */
    public boolean next() {
        if(actualPrio < prio.size()) {
            actualPrio++;
            return true;
        }
        return false;
    }

    /**
     * Metodo que inicia el map de prio
     */
    public void start() {
        this.actualPrio = firstPrio-1;
        this.hadPrio.clear();
    }

    /**
     * Metodo que comprueba si una celula pasada por parametero tiene prioridad
     * @param c Celula sobre la que se quiere comprobar si tiene prioridad
     * @return x Devuelve verdadero si la celula tiene prioridad y falso en caso contrario
     */
    public boolean hasPriority(Cell c){
        return prio.get(c.getClass()) == actualPrio;
    }

    /**
     * Metodo que consume la prioridad de la celula pasada como parametro,
     * tiene que comprobrar primero si tiene prioridad para llamar a este.
     * @param c Celula sobre la que se quiere comprobar si tiene prioridad
     */
    public void consumePriority(Cell c){
        this.hadPrio.add(c);
    }

    /**
     * Metodo que comprueba si una celula pasada por parametero tuvo prioridad
     * @param c Celula sobre la que se quiere comprobar si tuvo prioridad
     * @return x Devuelve verdadero si la celula tuvo prioridad y falso en caso contrario
     */
    public boolean hadPriority(Cell c) {
        return actualPrio > prio.get(c.getClass()) || this.hadPrio.contains(c);
    }
}
