package server;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestData {
    private Map<String,Integer>  cells=new HashMap<String,Integer>();

    RequestData(String immobileCell, int numImm, String mobileCell, int numMobile, String reproductiveCell, int numRepro){
        cells.put(immobileCell,numImm);
        cells.put(mobileCell,numMobile);
        cells.put(reproductiveCell,numRepro);
    }

    public Map<String, Integer> getCells() {
        return cells;
    }

    public void setCells(Map<String, Integer> cells) {
        this.cells = cells;
    }
}
