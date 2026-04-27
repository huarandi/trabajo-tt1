package server;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Path("/Resultados")
public class Resultados {
    private RequestManager req;
    private GameTokens gameTokens;

    @Inject
    public Resultados(RequestManager requestManager){
        req = requestManager;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getResultados(@QueryParam("nombreUsuario") String usr, @QueryParam("tok") int tok) {

        JsonObject response=new JsonObject();
        Map<String,Integer> data=new ConcurrentHashMap<String,Integer>();
        if(gameTokens.checkGame(tok)){

            Game game=gameTokens.getGame(tok);

            response.addProperty("done",true);
            response.addProperty("tokenSolicitud",tok);
            response.addProperty("errormessage","");
            response.addProperty("data",game.toString());


        }else{
            response.addProperty("done",false);
            response.addProperty("tokenSolicitud","400");
            response.addProperty("errormessage","Error, el token no existe");
            response.addProperty("data","");
        }
        return response.toString();
    }
}
