package logic;

import model.Cell;
import model.ImmobileCell;
import model.MobileCell;
import model.ReproductiveCell;

import java.util.HashMap;
import java.util.Map;

public class CellPrioritizer {
    private int actualPrio;

    private Map<Class<?>, Integer> prio = new HashMap<>();

    public CellPrioritizer() {
        prio.put(ImmobileCell.class, 0);
        prio.put(MobileCell.class, 1);
        prio.put(ReproductiveCell.class, 2);

        actualPrio = 0;
    }

    public boolean next() {
        if(actualPrio < prio.size()) {
            actualPrio++;
            return true;
        }
        return false;
    }

    public boolean hasPriority(Cell c){
        return prio.get(c.getClass()) == actualPrio;
    }
}
