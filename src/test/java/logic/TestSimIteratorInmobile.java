package logic;

import model.Board;
import model.BoardChange;
import model.ImmobileCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestSimIteratorInmobile
{
    private SimIterator simIterator;
    private ImmobileCell ic;
    private BoardChange boardChange;

    @Before
    public void before() throws Exception
    {
        this.simIterator = new SimIterator();
        this.ic = new ImmobileCell();
        this.boardChange = new BoardChange(0,0,ic);
    }

    @Test
    public void postIterativeInmobile()
    {
        List<BoardChange> l = this.simIterator.IterativeInmobile(this.ic);

        Assert.assertTrue(l.contains(this.boardChange));
        Assert.assertEquals(1, l.size());
    }
}
