package org.nttdata.bootcamp.quarkus.tarjeta.ws.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.nttdata.bootcamp.quarkus.tarjeta.model.Tarjeta;
import org.nttdata.bootcamp.quarkus.tarjeta.service.TarjetaService;
import org.nttdata.bootcamp.quarkus.tarjeta.ws.vo.TarjetaVO;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Path("ms-target-banco/target")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TarjetaResource {

    @Inject
    TarjetaService tarjetaService;

    @POST
    @Path("/save")
    public Response registrarTarjeta(TarjetaVO tarjeta) {
        Map<String, Object> response = tarjetaService.createTarget(tarjeta);
        return Response.ok(response).build();
    }

    @GET
    public Response listarTarjetas() {
        List<Tarjeta> response = tarjetaService.findAll();
        return response.isEmpty() ? Response.noContent().build() : Response.ok(response).build();
    }

    @GET
    @Path("/activos")
    public Response listarTarjetasActivas() {
        List<Tarjeta> response = tarjetaService.findAllByActivos();
        return response.isEmpty() ? Response.noContent().build() : Response.ok(response).build();
    }

    @PUT
    @Path("/update")
    public Response actualizarTarjeta(Tarjeta tarjeta) {
        Map<String, Object> response = tarjetaService.updateTarget(tarjeta);
        return Response.ok(response).build();
    }

    @PUT
    @Path("/delete/{id}")
    public Response eliminarTarjeta(@PathParam("id") Long id) {
        Map<String, Object> response = tarjetaService.deleteTarger(id);
        return Response.ok(response).build();
    }

}
