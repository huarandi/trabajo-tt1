package server;

import logic.Simulator;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SimulatorTokens {

    private static Map<Integer, Simulator> table=new ConcurrentHashMap<Integer, Simulator>();

    private SimulatorTokens(){
        table=new ConcurrentHashMap<>();
    }

    private boolean addSimulation(int token, Simulator simulation){
        return table.put(token, simulation) != null;
    }

    private Simulator getSimulation(int token){
        return table.get(token);
    }

    private void removeSimulation(int token){
        table.remove(token);
    }

    private boolean checkSimulation(int token){
        return table.get(token)!=null;
    }

    public static Map<Integer, Simulator> getTable() {
        return table;
    }

    public static void setTable(Map<Integer, Simulator> table) {
        SimulatorTokens.table = table;
    }
}
