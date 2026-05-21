package logic;

import model.Board;
import model.BoardChange;
import model.Cell;

import java.util.List;

/**
 * Esta clase implementa la interfaz InterfaceSimulator siendo la clase base de la ejecucion de la simulacíon
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
public class Simulator implements InterfaceSimulator
{
    private SimIterator it;
    private CellPrioritizer pri;
    /**
     * Constructor de clase
     * @param it Objeto de la clase SimIterator que define el iterador que comprobora los cambios que haran las celulas
     * @param pri Objeto de la clase CellPrioritizer que devuelve las prioridades de las celulas
     */
    public Simulator(SimIterator it, CellPrioritizer pri) {
        this.it = it;
        this.pri = pri;
    }

    /**
     * Metodo el cual a partir de un tablero inicial realiza la simulacion para el siguiente tablero
     * @param b0 Objeto de la clase SimIterator que define el iterador que comprobora los cambios que haran las celulas
     */
    @Override
    public Board simulate(Board b0) {
        Board b1 = (Board) b0.clone();
        pri.start();

        while(pri.next()){
            for(int i = 0; i < b0.getxMax();  i++){
                for(int j = 0; j < b0.getyMax(); j++){
                    Cell c = b0.getCell(i, j);
                    if(c != null && (pri.hasPriority(c) && !pri.hadPriority(c))){

                        List<BoardChange> chs =  c.iterate(this.it);
                        int[] pos = positionOf(c, b0);
                        Board rollback = (Board) b1.clone();
                        for(BoardChange ch : chs){
                            boolean success = applyChange(ch, b1, pos);
                            pri.consumePriority(c);
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

    /**
     * Método que devuelve la posicion de una celula en el tablero
     * @param c Celula sobre la que se quiere buscar su posicion
     * @param b Tablero sobre el que esta situada la celula
     * @return Devuelve un vector de int con la posicion en el tablero
     */
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

    /**
     * Método que aplica los cambios que quiere realizar la celula en el siguiente instante de la simulacion
     * @param bc Cambios que quiere realizar la celula
     * @param b Tablero actual de la simulacion
     * @param originalPosition Posicion actual de la celula
     * @return Devuelve verdadero si se consigue realizar el cambio y falso en caso contrario
     */
    private boolean applyChange(BoardChange bc, Board b, int[] originalPosition)
    {
            int x = originalPosition[0] + bc.getX();
            int y = originalPosition[1] + bc.getY();
            if(x >= b.getxMax() || y >= b.getyMax() || x < 0 || y < 0) return false;
            if(b.getCell(x, y) != null && pri.hadPriority(b.getCell(x, y))) return false;
            b.insertCell(bc.getCell(), x, y);
            return true;
    }
}
