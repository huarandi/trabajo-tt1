package server;

import logic.Simulator;
import model.*;

import java.util.Random;

public class ThreadGame extends Thread
{
    private int numInmobil;
    private int numMobil;
    private int numReproductive;
    private Game game;
    private int token;

    public ThreadGame(RequestData requestData, int t)
    {
        this.numInmobil=requestData.getCells().get("static");
        this.numMobil=requestData.getCells().get("dynamic");
        this.numReproductive=requestData.getCells().get("reproductive");
        this.token = t;
    }

    public void run()
    {
        Random random=new Random();
        int tmax=this.numInmobil+this.numReproductive+this.numMobil;


        Board board=new Board(tmax, tmax);

        //Insertar celulas inmobiles

        Cell cell = new ImmobileCell();
        int posX;
        int posY;

        for(int i=0;i<this.numInmobil;i++)
        {
            do
            {
                posX = random.nextInt(0, tmax);
                posY = random.nextInt(0, tmax);
            }
            while (!board.isEmpty(posX,posY));

            board.insertCell(cell, posX, posY);
        }

        //Insertar celulas Mobiles

        cell = new MobileCell();

        for(int j=0;j<this.numMobil;j++)
        {
            do
            {
                posX = random.nextInt(0, tmax);
                posY = random.nextInt(0, tmax);
            }
            while (!board.isEmpty(posX,posY));

            board.insertCell(cell, posX, posY);
        }

        //Insertar celulas Reproductoras

        cell = new ReproductiveCell();

        for(int k=0;k<this.numReproductive;k++)
        {
            do
            {
                posX = random.nextInt(0, tmax);
                posY = random.nextInt(0, tmax);
            }
            while (!board.isEmpty(posX,posY));

            board.insertCell(cell, posX, posY);
        }

        //Creacion del juego, 50 instantes

        int numInstantsGame = 50;
        Game game = new Game(board, numInstantsGame);
        Board b0;
        Board b1;

        Simulator simulator = new Simulator();


        for(int ti = 0; ti < numInstantsGame; ti++)
        {
            b0 = game.getBoard(ti);
            b1 = simulator.simulate(b0);
            if(ti + 1 < numInstantsGame)
            {
                game.addBoard(b1, ti+1);
            }
        }
    }

    public Game getGame()
    {
        return game;
    }

    public int getToken() {
        return token;
    }
}
