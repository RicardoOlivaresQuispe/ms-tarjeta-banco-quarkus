package org.nttdata.bootcamp.quarkus.tarjeta.service;

import org.nttdata.bootcamp.quarkus.tarjeta.model.Tarjeta;
import org.nttdata.bootcamp.quarkus.tarjeta.ws.vo.TarjetaVO;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface TarjetaService {

    Map<String, Object> createTarget(TarjetaVO request);


    Map<String, Object> updateTarget(Tarjeta taget);

    Map<String, Object> deleteTarger(Long id);

    List<Tarjeta> findAll();
    List<Tarjeta> findAllByActivos();

}
