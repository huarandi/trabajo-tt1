package server;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import server.mock.RequestManagerMock;

public class ResultadosUnitTest {
    private Resultados resultado;

    private final String USER = "usuario";
    private static int TOKEN;
    private static int BAD_TOKEN;

    @BeforeClass
    public static void setUpClass() {
        TOKEN=1;
        BAD_TOKEN=546;
    }

    @Before
    public void setUp() {
        RequestManagerMock reqmock = new RequestManagerMock(false);
        resultado = new Resultados(reqmock);
    }

    @Test
    public void getResultadosBadRequest(){
        String strRes = resultado.getResultados(USER, BAD_TOKEN);

        JsonObject res = JsonParser.parseString(strRes).getAsJsonObject();
        Assert.assertNotNull(res);
        Assert.assertNotNull(res.get("done").getAsBoolean());
        Assert.assertNotNull(res.get("tokenSolicitud").getAsInt());
        Assert.assertNotNull(res.get("errormessage").getAsString());
        Assert.assertNotNull(res.get("data").getAsBoolean());
    }

    @Test
    public void getResultadosGoodRequest(){
        String strRes = resultado.getResultados(USER, TOKEN);

        JsonObject res = JsonParser.parseString(strRes).getAsJsonObject();
        Assert.assertNotNull(res);
        Assert.assertNotNull(res.get("done").getAsBoolean());
        Assert.assertNotNull(res.get("tokenSolicitud").getAsInt());
        Assert.assertNotNull(res.get("errormessage").getAsString());
        Assert.assertNotNull(res.get("data").getAsBoolean());
    }
}
