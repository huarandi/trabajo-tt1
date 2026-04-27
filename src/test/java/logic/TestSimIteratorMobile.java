package logic;

import model.BoardChange;
import model.ImmobileCell;
import model.MobileCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestSimIteratorMobile
{
    private SimIterator simIterator;
    private MobileCell mc;

    @Before
    public void before() throws Exception
    {
        this.simIterator = new SimIterator();
        this.mc = new MobileCell();
    }

    @Test
    public void postIterativeInmobile()
    {
        BoardChange bc1 = new BoardChange(-1,0,this.mc);
        BoardChange bc2 = new BoardChange(0,-1,this.mc);
        BoardChange bc3 = new BoardChange(1,0,this.mc);
        BoardChange bc4 = new BoardChange(0,1,this.mc);
        BoardChange bc0 = new BoardChange(0,0, null);

        List<BoardChange> l = this.simIterator.IterativeMobile(this.mc);
        Assert.assertTrue(l.contains(bc0));
        Assert.assertTrue(l.contains(bc1) ^ l.contains(bc2) ^ l.contains(bc3) ^ l.contains(bc4));
        Assert.assertEquals(2, l.size());
    }
}
