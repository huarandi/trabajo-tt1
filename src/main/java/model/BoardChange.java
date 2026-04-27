package model;

public class BoardChange
{
    private int x;
    private int y;
    private Cell cell;

    public BoardChange(int x, int y, Cell cell)
    {
        this.x=x;
        this.y=y;
        this.cell = cell;
    }
    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public Cell getCell()
    {
        return this.cell;
    }

    public boolean equals(BoardChange bc)
    {
        return this.x == bc.x && this.y == bc.y && this.cell.equals(bc.cell);
    }
}
