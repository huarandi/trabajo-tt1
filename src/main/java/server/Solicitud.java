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

@Path("/Solicitud")
public class Solicitud {

    private final RequestManager req;

    @Inject
    public Solicitud(RequestManager requestManager){
        req = requestManager;
    }

    @POST
    @Path("Solicitar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postSolicitudSolicitar(@QueryParam("nombreUsuario") String usr, String jsonBody) {

        JsonObject response=new JsonObject();
        Map<String,Integer> data=new ConcurrentHashMap<String,Integer>();

        try{
            JsonObject body=JsonParser.parseString(jsonBody).getAsJsonObject();
            JsonArray tipos= body.get("nombreEntidades").getAsJsonArray();
            JsonArray cantidad=body.get("cantidadesIniciales").getAsJsonArray();

            for(int i=0;i< tipos.size();i++){
                data.put(tipos.get(i).getAsString(),cantidad.get(i).getAsInt());
            }

            RequestData requestData=new RequestData(data);

            int token=req.requestSimulation(requestData);
            Game game=req.getResults(token);

            GameTokens gameTokens=new GameTokens();
            //gameTokens.addGame(token,game);

            response.addProperty("done",true);
            response.addProperty("tokenSolicitud",token);
            response.addProperty("errormessage","");
            response.addProperty("data","game.toString()");


        }catch (Exception e){
            response.addProperty("type","");
            response.addProperty("title","");
            response.addProperty("status",404);
            response.addProperty("detail","");
            response.addProperty("instance","");
            response.addProperty("additionalProp1","");
            response.addProperty("additionalProp2","");
            response.addProperty("additionalProp3","");
        }
        return response.toString();
    }
}
