package org.nttdata.bootcamp.quarkus.tarjeta.ws.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.nttdata.bootcamp.quarkus.tarjeta.ws.vo.ClienteVO;

@Path("/client")
@RegisterRestClient(configKey = "cliente-api")
public interface ClienteCallClient {

    @GET
    @Path("/findNumberDoc/{numDocu}")
        //http://localhost:8082/ms-client-banco/client/findNumberDoc/78541285
    ClienteVO buscarClientePorDocumento(@PathParam("numDocu") String numDocu);
}
