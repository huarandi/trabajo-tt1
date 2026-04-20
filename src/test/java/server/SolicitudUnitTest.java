package server;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import server.mock.RequestManagerMock;

public class SolicitudUnitTest {

    private Solicitud solicitud;

    private final String USER = "usuario";
    private static String REQUEST;
    private static String BAD_REQUEST = "";

    @BeforeClass
    public static void setUpClass() {
        JsonObject req = new JsonObject();
        JsonArray cant = new JsonArray();
        cant.add(10);
        cant.add(20);
        cant.add(30);
        req.add("cantidadesIniciales", cant);

        JsonArray ents = new JsonArray();
        ents.add("dynamic");
        ents.add("static");
        ents.add("reproductive");
        req.add("nombreEntidades", ents);

        REQUEST = req.toString();
    }

    @Before
    public void setUp() {
        RequestManagerMock reqmock = new RequestManagerMock(false);
        solicitud = new Solicitud(reqmock);
    }

    @Test
    public void postSolicitudSolicitarBadRequest(){
        String strRes = solicitud.postSolicitudSolicitar(USER, BAD_REQUEST);

        JsonObject res = JsonParser.parseString(strRes).getAsJsonObject();
        Assert.assertNotNull(res);
        Assert.assertNotNull(res.get("type").getAsString());
        Assert.assertNotNull(res.get("title").getAsString());
        Assert.assertNotNull(res.get("status").getAsInt());
        Assert.assertNotNull(res.get("detail").getAsString());
        Assert.assertNotNull(res.get("instance").getAsString());
        Assert.assertNotNull(res.get("additionalProp1").getAsString());
        Assert.assertNotNull(res.get("additionalProp2").getAsString());
        Assert.assertNotNull(res.get("additionalProp3").getAsString());
    }

    @Test
    public void postSolicitudSolicitarGoodRequest(){
        String strRes = solicitud.postSolicitudSolicitar(USER, REQUEST);

        JsonObject res = JsonParser.parseString(strRes).getAsJsonObject();
        Assert.assertNotNull(res);
        Assert.assertNotNull(res.get("done").getAsBoolean());
        Assert.assertNotNull(res.get("tokenSolicitud").getAsInt());
        Assert.assertNotNull(res.get("errormessage").getAsString());
        Assert.assertNotNull(res.get("data").getAsBoolean());
    }
}
