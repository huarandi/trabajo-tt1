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

@Path("/Resultados")
public class Resultados {
    private RequestManager req;
    private final GameTokens gameTokens=GameTokens.getInstance();

    @Inject
    public Resultados(RequestManager requestManager){
        req = requestManager;
    }

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

    private String buildDataString(Game g) {
        StringBuilder data=new StringBuilder();
        int t = Math.max(g.getBoard(0).getxMax(),g.getBoard(0).getyMax());
        data.append(t);
        data.append("\n");
        for(int i=0;i<=g.boards().length;i++){
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
