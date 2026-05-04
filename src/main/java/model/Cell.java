package model;

import logic.SimIterator;

import java.util.List;

public abstract class Cell
{
    public abstract String toString();

    public abstract List<BoardChange> iterate(SimIterator it);
}
