package model;

/**
 * Esta clase define el tablero sobre el que se desarrollara la simulación
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
public class Board
{
    private Cell[][] positions;
    private int xMax;
    private int yMax;

    /**
     * Constructor que genera el tablero de la simulaicon en un instante
     * @param x numero de filas que tendra el tablero de la simulacion
     * @param y numero de columnas que tendra el tablero de la simulacion
     */
    public Board(int x, int y)
    {
        this.positions = new Cell[x][y];
        this.xMax = x;
        this.yMax = y;
    }

    /**
     * Método que inserta una Cell en la coordenada pasada como parametro
     * @param c Cell de la simulacion
     * @param x Fila en la que se situara la Cell en el tablero de la simulación
     * @param y Columna en la que se situara la Cell en el tablero de la simulación
     */
    public void insertCell(Cell c, int x, int y)
    {
        this.positions[x][y] = c;
    }

    /**
     * Método que elimina una Cell en la coordenada pasada como parametro
     * @param x Fila en la que se situara la Cell que vamos a eliminar del tablero de la simulación
     * @param y Columna en la que se situara la Cell que vamos a eliminar del tablero de la simulación
     */
    public void removeCell( int x, int y)
    {
        this.positions[x][y] = null;
    }

    /**
     * Método que devuelve la Cell situada en la fila y columnas pasadas como parametro
     * @param x
     * @param y
     * @return La Cell en la posicion pasada como parametros
     */
    public Cell getCell(int x, int y)
    {
        return this.positions[x][y];
    }

    /**
     * Método que transforma el objeto de la clase en un String
     * @return  String con los datos del objeto de la clase
     */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();

        for (int y = 0; y < this.yMax; y++)
        {
            for (int x = 0; x < this.xMax; x++)
            {
                if (this.positions[x][y] == null)
                {
                    s.append("000");
                }
                else
                {
                    s.append(this.positions[x][y].toString());
                }

                if (x < this.xMax - 1)
                {
                    s.append(" | ");
                }
            }
            s.append("\n");
        }

        return s.toString();
    }

    /**
     * Método que devuelve el tamaño maximo de filas del tablero de la simulación
     * @return  Integer con el valor del tamaño maximo de filas
     */
    public int getxMax()
    {
        return this.xMax;
    }

    /**
     * Método que devuelve el tamaño maximo de columnas del tablero de la simulación
     * @return  Integer con el valor del tamaño maximo de columnas
     */
    public int getyMax()
    {
        return this.yMax;
    }

    /**
     * Método que devuelve verdadero si la casilla del tablero esta vacia y falso en caso contrario
     * @return  Boolean dependiendo si la casilla esta vacia o no
     */
    public boolean isEmpty(int x, int y)
    {
        return this.positions[x][y] == null;
    }

    @Override
    public Object clone() {
        Board b = new Board(this.xMax, this.yMax);
        for(int x = 0; x < this.xMax; x++){
            for(int y = 0; y < this.yMax; y++){
                b.insertCell(this.getCell(x, y), x, y);
            }
        }
        return b;
    }
}

