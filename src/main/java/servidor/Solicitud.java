package servidor;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/Solicitud")
public class Solicitud {
    @POST
    @Path("Solicitar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postSolicitudSolicitar(@QueryParam("nombreUsuario") String usr) {
        return "Solicitudes test: " + usr;
    }
}
