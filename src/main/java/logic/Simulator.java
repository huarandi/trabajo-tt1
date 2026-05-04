package logic;

import model.Board;
import model.BoardChange;

import java.util.List;
import java.util.Random;

public class Simulator implements InterfaceSimulator
{
    private Random r;

    public Simulator(){}
    public Simulator(Random r)
    {
        this.r=r;
    }

    @Override
    public Board simulate(Board b0)
    {
        return null;
    }

    public void addCells(List<BoardChange> l, Board b)
    {
        for(BoardChange bc: l)
        {
            b.insertCell(bc.getCell(), bc.getX(), bc.getY());
        }
    }

}
