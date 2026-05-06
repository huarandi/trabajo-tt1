package model;

/**
 * Esta clase define los cambios sobre el tablero
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */

public class BoardChange
{
    private int x;
    private int y;
    private Cell cell;

    /**
     * Método que genera el los cambios en el tablero de la simulaicon en un instante
     * @param x numero de filas que tendra el tablero de la simulacion
     * @param y numero de columnas que tendra el tablero de la simulacion
     */
    public BoardChange(int x, int y, Cell cell)
    {
        this.x=x;
        this.y=y;
        this.cell = cell;
    }

    /**
     * Método que devuelve la fila de la Cell en el tablero
     * @return Integer con la posicion de la Cell
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Método que devuelve la fila de la Cell en el tablero
     * @return Integer con la posicion de la Cell
     */
    public int getY()
    {
        return this.y;
    }

    public Cell getCell()
    {
        return this.cell;
    }

    public boolean equals(Object bc)
    {
        if(bc instanceof BoardChange bcc){
            return this.x == bcc.x && this.y == bcc.y && this.cell.equals(bcc.cell);
        }
        return false;
    }
}
