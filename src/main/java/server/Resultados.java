package server;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/Resultados")
public class Resultados {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getResultados(@QueryParam("nombreUsuario") String usr, @QueryParam("tok") int tok) {
        return  "Ressultados test: " + usr + "," + tok;
    }
}
