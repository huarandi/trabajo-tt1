package logic;

import model.Board;
import model.ImmobileCell;
import model.MobileCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSimulatorMobileCell
{
    private Simulator simulator;
    private Board board;
    private MobileCell mc;


    @Before
    public void before() throws Exception
    {
        this.simulator = new Simulator();
        this.board = new Board(3,3);
        this.mc = new MobileCell();
        this.board.insertCell(mc,0,0);
    }

    @Test
    public void postSimulateMobileCell()
    {

        Board b1 = this.simulator.simulate(this.board);

        boolean b = b1.getCell(0,1).equals(this.mc) ^
                    b1.getCell(1,0).equals(this.mc) ^
                    b1.getCell(2,1).equals(this.mc) ^
                    b1.getCell(1,2).equals(this.mc);

        Assert.assertNull(b1.getCell(1, 1));
        Assert.assertTrue(b);
    }
}
