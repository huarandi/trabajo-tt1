package server;

import logic.CellPrioritizer;
import logic.SimIterator;
import logic.Simulator;
import model.*;

import java.util.Random;
import java.util.concurrent.Callable;

public class ThreadGame implements Callable<Game>
{
    private int numInmobil;
    private int numMobil;
    private int numReproductive;
    private Game game;

    /**
     * Constructor de la clase que genera el numero de celulas de cada tipo a partir de requestData
     * @Param requestData Informacion sobre la peticion a simular
     */
    public ThreadGame(RequestData requestData)
    {
        this.numInmobil=requestData.getCells().get("static");
        this.numMobil=requestData.getCells().get("dynamic");
        this.numReproductive=requestData.getCells().get("reproductive");
    }

    /**
     * Metodo call del hilo, crea el primer board de forma aleatoria a partir del numero de celulas de cada tipo y despues simula 50 instantes a partir de este y los guarda en game
     * @return devuelve el game con la simulacion
     */
    public Game call()
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
        this.game = new Game(board, numInstantsGame);
        Board b0;
        Board b1;

        SimIterator simIterator = new SimIterator();
        CellPrioritizer cellPrioritizer = new CellPrioritizer();
        Simulator simulator = new Simulator(simIterator, cellPrioritizer);


        for(int ti = 0; ti < numInstantsGame; ti++)
        {
            b0 = this.game.getBoard(ti);
            b1 = simulator.simulate(b0);
            if(ti + 1 < numInstantsGame)
            {
                this.game.addBoard(b1, ti+1);
            }
        }

        return this.game;
    }
}
