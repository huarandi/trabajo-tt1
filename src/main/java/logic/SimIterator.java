package logic;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimIterator
{
    private Random r;

    public SimIterator()
    {
        this.r = new Random();
    }

    public SimIterator(Random random)
    {
        this.r = random;
    }

    public List<BoardChange> IterativeInmobile(Cell c)
    {
        List<BoardChange> l = new ArrayList<BoardChange>();
        BoardChange b = new BoardChange(0,0, c);
        l.add(b);
        return l;
    }

    public List<BoardChange> IterativeMobile(Cell c)
    {
        List<BoardChange> l = new ArrayList<BoardChange>();
        BoardChange b = new BoardChange(0,0, null);
        l.add(b);
        int choice = r.nextInt(0,4);
        switch (choice)
        {
            case(0):
            {
                b = new BoardChange(-1,0,c);
            }
            case(1):
            {
                b = new BoardChange(0,-1,c);
            }
            case(2):
            {
                b = new BoardChange(1,0,c);
            }
            case(3):
            {
                b = new BoardChange(0,1,c);
            }
        }
        l.add(b);

        return l;
    }

    //Probabilidad de reproducirse 1/3
    public List<BoardChange> IterativeReproductive(Cell c)
    {

        List<BoardChange> l = new ArrayList<BoardChange>();
        BoardChange b = new BoardChange(0,0, c);
        l.add(b);

        int choiceWillReproductive = r.nextInt(0,3);
        if(choiceWillReproductive == 0)
        {
            int choiceDirection = r.nextInt(0,4);
            switch (choiceDirection)
            {
                case(0):
                {
                    b = new BoardChange(-1,0,c);
                }
                case(1):
                {
                    b = new BoardChange(0,-1,c);
                }
                case(2):
                {
                    b = new BoardChange(1,0,c);
                }
                case(3):
                {
                    b = new BoardChange(0,1,c);
                }
            }
            l.add(b);
        }
        return l;
    }
}
