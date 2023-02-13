package org.nttdata.bootcamp.quarkus.tarjeta.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.nttdata.bootcamp.quarkus.tarjeta.model.Tarjeta;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class TarjetaRepository implements PanacheRepository<Tarjeta> {

    public Tarjeta findTarjetaDebitoByNroTarjeta(String numeroTarjeta) {
        return find("numTarjeta", numeroTarjeta).firstResultOptional().orElseThrow(NotFoundException::new);
    }

    public List<Tarjeta> findTajetaByNroDocumento(String numDoc) {
        return find("numero_documento_cliente", numDoc).list();
    }

}
