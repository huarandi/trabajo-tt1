package logic;

import model.BoardChange;
import model.ImmobileCell;
import model.ReproductiveCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSimIteratorReproductive
{
    private SimIterator simIterator;
    private ReproductiveCell rc;
    private int numberIterations;

    @Before
    public void before() throws Exception
    {
        this.simIterator = new SimIterator();
        this.rc = new ReproductiveCell();
        this.numberIterations=20;
    }

    @Test
    public void postIterativeReproductive()
    {
        BoardChange bc0 = new BoardChange(0,0, this.rc);
        BoardChange bc1 = new BoardChange(-1,0,this.rc);
        BoardChange bc2 = new BoardChange(0,-1,this.rc);
        BoardChange bc3 = new BoardChange(1,0,this.rc);
        BoardChange bc4 = new BoardChange(0,1,this.rc);
        BoardChange bcNull = new BoardChange(0,0, null);

        List<BoardChange> l = new ArrayList<>();
        for(int i = 0; i < this.numberIterations; i++)
        {
            l.addAll(this.simIterator.IterativeReproductive(this.rc));
        }
        Assert.assertTrue(l.contains(bc0));
        Assert.assertFalse(l.contains(bcNull));

        boolean b = l.contains(bc1) || l.contains(bc2) || l.contains(bc3) || l.contains(bc4);

        Assert.assertTrue(b);

    }
}
