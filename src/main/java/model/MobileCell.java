package model;

import logic.SimIterator;

import java.util.List;

public class MobileCell extends Cell
{
    @Override
    public String toString()
    {
        return "020";
    }

    @Override
    public List<BoardChange> iterate(SimIterator it) {
        return it.iterativeMobile(this);
    }
}
