package model;

import logic.SimIterator;

import java.util.List;

public class ImmobileCell extends Cell
{
    @Override
    public String toString()
    {
        return "010";
    }

    @Override
    public List<BoardChange> iterate(SimIterator it) {
        return it.iterativeInmobile(this);
    }

    @Override
    public String getColor() {
        return "red";
    }
}
