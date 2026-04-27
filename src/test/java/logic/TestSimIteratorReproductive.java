package logic;

import model.BoardChange;
import model.ImmobileCell;
import model.ReproductiveCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        /*
        List<BoardChange> l = this.simIterator.IterativeReproductive(this.rc);

        BoardChange bc0 = new BoardChange(0,0, this.rc);

        Assert.assertTrue(l.contains(bc0));
        Assert.assertTrue(3, ;
        */
    }
}
