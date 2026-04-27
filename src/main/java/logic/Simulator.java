package logic;

import model.Board;

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
    public Board simulate(Board b0) {
        return null;
    }
}
