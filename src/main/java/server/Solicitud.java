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

/**
 * Esta clase gestiona las peticiones de solicitud recibidas en el servidor
 * @author: Hugo Arandia, Ramon Sanchez, Diego Anguas
 * @version: 1.0
 */
@Path("/Solicitud")
public class Solicitud {

    private final RequestManager req;

    /**
     * Constructor de la clase que inyecta el gestor de peticiones
     * @param requestManager Objeto que define el gestor de peticiones
     */
    @Inject
    public Solicitud(RequestManager requestManager){
        req = requestManager;
    }

    /**
     * Metodo que gestiona la peticion
     * @param usr Nombre de usuario
     * @param jsonBody String en formato json que contiene los datos iniciales de la simulacion
     * @return Devuelve un string con la simulacion y el token identificativo de la misma
     */
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

            response.addProperty("done",true);
            response.addProperty("tokenSolicitud",token);
            response.addProperty("errormessage","");
            response.addProperty("data","");


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
