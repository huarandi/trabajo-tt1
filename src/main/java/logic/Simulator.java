package logic;

import model.Board;
import model.BoardChange;
import model.Cell;

import java.util.List;

public class Simulator implements InterfaceSimulator
{
    private SimIterator it;
    private CellPrioritizer pri;

    public Simulator(SimIterator it, CellPrioritizer pri) {
        this.it = it;
        this.pri = pri;
    }

    @Override
    public Board simulate(Board b0) {
        Board b1 = b0;
        pri.start();

        while(pri.next()){
            for(int i = 0; i < b0.getxMax();  i++){
                for(int j = 0; j < b0.getyMax(); j++){
                    Cell c = b0.getCell(i, j);
                    if(c != null && pri.hasPriority(c)){
                        List<BoardChange> chs =  c.iterate(this.it);
                        int[] pos = positionOf(c, b0);
                        Board rollback = b1;
                        for(BoardChange ch : chs){
                            boolean success = applyChange(ch, b1, pos);
                            if(!success){
                                b1 = rollback;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return b1;
    }

    private int[] positionOf(Cell c, Board b){
        int[] pos = new int[2];
        for(int i = 0; i < b.getxMax(); i++){
            for(int j = 0; j < b.getyMax(); j++){
                if(b.getCell(i, j) != null && b.getCell(i, j).equals(c)){
                    pos[0] =  i;
                    pos[1] = j;
                    break;
                }
            }
        }
        return pos;
    }

    private boolean applyChange(BoardChange bc, Board b, int[] originalPosition)
    {
            int x = originalPosition[0] + bc.getX();
            int y = originalPosition[1] + bc.getY();
            if(x >= b.getxMax() || y >= b.getyMax()) return false;
            if(b.getCell(x, y) != null && pri.hadPriority(b.getCell(x, y))) return false;
            b.insertCell(bc.getCell(), x, y);
            return true;
    }
}
