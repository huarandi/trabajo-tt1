package logic;

import model.Board;
import model.ImmobileCell;
import model.MobileCell;
import model.ReproductiveCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSimulatorReproductiveCell
{
    private Simulator simulator;
    private Board board;
    private ReproductiveCell rc;
    private int numberIterations;


    @Before
    public void before() throws Exception
    {
        this.simulator = new Simulator();
        this.board = new Board(3,3);
        this.rc = new ReproductiveCell();
        this.board.insertCell(rc,1,1);
        this.numberIterations=20;
    }

    @Test
    public void postSimulateReproductiveCell()
    {
        for(int i = 0; i < this.numberIterations; i++)
        {
            this.board = this.simulator.simulate(this.board);
        }

        boolean b = this.board.getCell(0,1).equals(this.rc) ||
                    this.board.getCell(1,0).equals(this.rc) ||
                    this.board.getCell(2,1).equals(this.rc) ||
                    this.board.getCell(1,2).equals(this.rc);

        Assert.assertEquals(this.rc, this.board.getCell(1,1));
        Assert.assertTrue(b);
    }
}