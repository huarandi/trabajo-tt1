package server;

import org.junit.Before;
import org.junit.Test;
import server.mock.RequestManagerMock;

public class SolicitudTest {

    private Solicitud solicitud;

    @Before
    public void setUp() {
        RequestManagerMock reqmock = new RequestManagerMock(false);
        solicitud = new Solicitud(reqmock);
    }

    @Test
    public void postSolicitudSolicitar(){

    }
}
