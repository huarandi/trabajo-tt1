package model;

public class Board
{
    private Cell[][] positions;
    private int xMax;
    private int yMax;

    public Board(int x, int y, int t)
    {
        this.positions = new Cell[x][y];
        this.xMax = x;
        this.yMax = y;
    }

    public void insertCell(Cell c, int x, int y)
    {
        this.positions[x][y] = c;
    }

    public void removeCell( int x, int y)
    {
        this.positions[x][y] = null;
    }

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


}

