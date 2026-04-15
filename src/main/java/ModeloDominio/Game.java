package ModeloDominio;

public class Game
{
    private Board[] boards;
    private int tMax;

    public Game(Board b, int tmax)
    {
        this.boards = new Board[tmax];
        this.boards[0] = b;
        this.tMax = tmax;
    }
    public Game(int tmax)
    {
        this.tMax = tmax;
    }


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

    public void addBoard(Board b, int t)
    {
        this.boards[t] = b;
    }

}
