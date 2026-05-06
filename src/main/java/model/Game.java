package model;

/**
 * Esta clase define el conjunto de tableros que conforman la simulacion
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
public class Game
{
    private Board[] boards;
    private int tMax;

    /**
     * Constructor de clase que genera el almacen de tableros de la simulacion a partir de un tablero inicial y un numero maximo de instantes
     * @param b  Tablero de la simulacion en el instante inicial
     * @param tmax Establece el numero maximo de instantes de la simulacion
     */
    public Game(Board b, int tmax)
    {
        this.boards = new Board[tmax];
        this.boards[0] = b;
        this.tMax = tmax;
    }

    /**
     * Constructor de clase que genera el almacen de tableros de la simulacion a partir de un numero maximo de instantes
     * @param tmax Establece el numero maximo de instantes de la simulacion
     */
    public Game(int tmax)
    {
        this.tMax = tmax;
    }

    /**
     * Metodo que genera un string a partir de un objeto de la clase
     * @return  Devuelve un String con el objeto
     */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < this.boards.length; i++)
        {
            if (this.boards[i] != null)
            {
                s.append(this.boards[i].toString());
                s.append("\n");
            }
        }

        return s.toString();
    }

    /**
     * Metodo que añade el tablero de la simulacion en el instante pasado
     * @param b  Tablero de la simulacion
     * @param t Establece el instante al que corresponde el tablero en la simulacion
     */
    public void addBoard(Board b, int t)
    {
        this.boards[t] = b;
    }

    /**
     * Metodo de clase que genera el almacen de tableros de la simulacion
     * @param t  Tablero de la simulacion en el instante inicial
     */
    public Board getBoard(int t)
    {
        return this.boards[t];
    }

    /**
     * Constructor de clase que genera el almacen de tableros de la simulacion
     * @return  board Devuelve el ablero en el ultimo instante de la simulacion
     */
    public Board finalBoard()
    {
        return this.boards[this.tMax];
    }

    /**
     * Constructor de clase que genera el almacen de tableros de la simulacion
     * @return Devuelve el conjunto de tableros de la simulacion
     */
    public Board[] boards()
    {
        return this.boards;
    }

}
