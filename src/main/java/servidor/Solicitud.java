package servidor;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/Solicitud")
public class Solicitud {
    @POST
    @Path("Solicitar")
    public String getSolicitudUsuario(@QueryParam("nombreUsuario") String usr) {
        return "Prueba solicitudes: " + usr;
    }
}
