package logic;

import model.Board;
import model.ImmobileCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSimulatorInmobileCell
{
    private Simulator simulator;
    private Board board;
    private ImmobileCell ic;


    @Before
    public void before() throws Exception
    {
        this.simulator = new Simulator();
        this.board = new Board(3,3);
        this.ic = new ImmobileCell();
        this.board.insertCell(ic,0,0);
    }

    @Test
    public void postSimulateInmobileCell()
    {
        Board b1 = this.simulator.simulate(this.board);

        Assert.assertEquals(this.ic, b1.getCell(0,0));
    }

}
