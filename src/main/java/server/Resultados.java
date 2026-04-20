package server;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/Resultados")
public class Resultados {
    private RequestManager req;

    @Inject
    public Resultados(RequestManager requestManager){
        req = requestManager;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getResultados(@QueryParam("nombreUsuario") String usr, @QueryParam("tok") int tok, String jsonBody) {
        return  "Ressultados test: " + usr + "," + tok;
    }
}
