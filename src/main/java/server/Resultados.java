package server;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Board;
import model.Game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/**
 * Esta clase gestiona las peticiones de resultado recibidas en el servidor
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
@Path("/Resultados")
public class Resultados {
    private RequestManager req;
    private final GameTokens gameTokens=GameTokens.getInstance();

    /**
     * Constructor de la clase que inyecta el gestor de peticiones
     * @param requestManager Objeto que define el gestor de peticiones
     */
    @Inject
    public Resultados(RequestManager requestManager){
        req = requestManager;
    }

    /**
     * Metodo que gestiona la peticion
     * @param usr Nombre de usuario
     * @param tok Identificador unico de cada simulacion
     * @return Devuelve un string con la simulacion del almacen asociada al token pasado como parametro
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getResults(@QueryParam("nombreUsuario") String usr, @QueryParam("tok") int tok) throws ExecutionException, InterruptedException {

        JsonObject response=new JsonObject();
        Map<String,Integer> data=new ConcurrentHashMap<String,Integer>();
        if(req.hasEnded(tok)){
            Game game = req.getResults(tok);

            response.addProperty("done",true);
            response.addProperty("tokenSolicitud",tok);
            response.addProperty("errormessage","");
            response.addProperty("data",buildDataString(game));


        }else{
            response.addProperty("done",false);
            response.addProperty("tokenSolicitud",400);
            response.addProperty("errormessage","Error, el token no existe");
            response.addProperty("data","");
        }
        return response.toString();
    }

    /**
     * Metodo que construye el string con la simulacion completa para devolverlo en la peticion
     * @param g Simulacion a pasar a string
     */
    private String buildDataString(Game g) {
        StringBuilder data=new StringBuilder();
        int t = Math.max(g.getBoard(0).getxMax(),g.getBoard(0).getyMax());
        data.append(t);
        data.append("\n");
        for(int i=0;i<g.boards().length;i++){
            Board  b=g.getBoard(i);
            for(int j = 0; j < b.getyMax(); j++){
                for(int k = 0;k < b.getxMax();k++){
                    if(b.getCell(k,j)!=null){
                        data.append(String.format("%d,%d,%d,%s", i, j, k, b.getCell(k,j).getColor()));
                        data.append("\n");
                    }
                }
            }
        }
        return  data.toString();
    }
}
