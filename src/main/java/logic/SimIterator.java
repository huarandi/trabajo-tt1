package logic;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Esta clase comprueba los cambios que quiere hacer cada pieza de la simulacion en el siguiente instante
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
public class SimIterator
{
    private Random r;

    /**
     * Constructor de clase que genera el numero aleatorio
     */
    public SimIterator()
    {
        this.r = new Random();
    }

    /**
     * Constructor de clase
     * @param random  Numero aleatorio
     */
    public SimIterator(Random random)
    {
        this.r = random;
    }

    /**
     * Metodo que proporicona la lista de cambios en el tablero actual que quiere hacer una celula inmovil en el siguiente instante
     * @return Devuelve la lista de BoardChange asociados a la celula inmovil
     */
    public List<BoardChange> iterativeInmobile(Cell c)
    {
        List<BoardChange> l = new ArrayList<BoardChange>();
        BoardChange b = new BoardChange(0,0, c);
        l.add(b);
        return l;
    }

    /**
     * Metodo que proporicona la lista de cambios en el tablero actual que quiere hacer una celula movil en el siguiente instante
     * @return Devuelve la lista de BoardChange asociados a la celula movil
     */
    public List<BoardChange> iterativeMobile(Cell c)
    {
        List<BoardChange> l = new ArrayList<BoardChange>();
        BoardChange b = new BoardChange(0,0, null);
        l.add(b);
        int choice = r.nextInt(0,4);
        switch (choice)
        {
            case(0):
            {
                b = new BoardChange(-1,0,c);
                break;
            }
            case(1):
            {
                b = new BoardChange(0,-1,c);
                break;
            }
            case(2):
            {
                b = new BoardChange(1,0,c);
                break;
            }
            case(3):
            {
                b = new BoardChange(0,1,c);
                break;
            }
        }
        l.add(b);

        return l;
    }

    /**
     * Metodo que proporicona la lista de cambios en el tablero actual que quiere hacer una celula reproductora en el siguiente instante,
     * la probabilidad de reproducirse 1/3
     * @return Devuelve la lista de BoardChange asociados a la celula reproductora
     */
    public List<BoardChange> iterativeReproductive(Cell c)
    {

        List<BoardChange> l = new ArrayList<BoardChange>();
        BoardChange b = new BoardChange(0,0, c);
        l.add(b);

        int choiceWillReproductive = r.nextInt(0,3);
        if(choiceWillReproductive == 0)
        {
            int choiceDirection = r.nextInt(0,4);
            switch (choiceDirection)
            {
                case(0):
                {
                    b = new BoardChange(-1,0,c);
                    break;
                }
                case(1):
                {
                    b = new BoardChange(0,-1,c);
                    break;
                }
                case(2):
                {
                    b = new BoardChange(1,0,c);
                    break;
                }
                case(3):
                {
                    b = new BoardChange(0,1,c);
                    break;
                }
            }
            l.add(b);
        }
        return l;
    }
}
