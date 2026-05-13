package model;

import logic.SimIterator;

import java.util.List;

public class ReproductiveCell extends Cell
{
    @Override
    public String toString()
    {
        return "030";
    }

    @Override
    public List<BoardChange> iterate(SimIterator it) {
        return it.iterativeReproductive(this);
    }

    @Override
    public String getColor()
    {
        return "blue";
    }
}
