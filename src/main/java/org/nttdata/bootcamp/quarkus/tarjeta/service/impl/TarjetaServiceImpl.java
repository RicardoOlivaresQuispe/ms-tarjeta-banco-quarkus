package org.nttdata.bootcamp.quarkus.tarjeta.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.nttdata.bootcamp.quarkus.tarjeta.model.Tarjeta;
import org.nttdata.bootcamp.quarkus.tarjeta.repository.TarjetaRepository;
import org.nttdata.bootcamp.quarkus.tarjeta.service.TarjetaService;
import org.nttdata.bootcamp.quarkus.tarjeta.util.Constantes;
import org.nttdata.bootcamp.quarkus.tarjeta.ws.client.ClienteCallClient;
import org.nttdata.bootcamp.quarkus.tarjeta.ws.vo.ClienteVO;
import org.nttdata.bootcamp.quarkus.tarjeta.ws.vo.TarjetaVO;

import java.util.*;

@ApplicationScoped
public class TarjetaServiceImpl implements TarjetaService {

    @Inject
    TarjetaRepository tarjetaRepository;
    @RestClient
    ClienteCallClient clienteCallClient;


    @Override
    @Transactional
    public Map<String, Object> createTarget(TarjetaVO request) {
        Map<String, Object> respuesta = new HashMap<>();
        ClienteVO clienteVO = clienteCallClient.buscarClientePorDocumento(request.getNumeroDocumento());
        if (Objects.nonNull(clienteVO)) {
            Tarjeta target = new Tarjeta();
            target.setNumTarjeta(request.getNumeroTarjeta());
            target.setPinTarjeta(Long.valueOf(request.getPinTarjeta()));
            target.setTipTarjeta(request.getTipoTarjeta());
            target.setFecVenc(request.getFechaVencimiento());
            target.setCodValTarj(request.getCodigoValidacion());
            target.setFecCorte(Objects.isNull(request.getFechaCorte()) ? null : request.getFechaCorte());
            target.setFecLimPagMens(Objects.isNull(request.getFechaLimitePagoMens()) ? null : request.getFechaLimitePagoMens());
            target.setSalActu(request.getSaldoActual());
            target.setLimCred(Objects.isNull(request.getLimiteCredito()) ? null : request.getLimiteCredito());
            target.setCuentBanc(request.getCuentaBancaria());
            target.setNumDocCli(request.getNumeroDocumento());
            target.setCliente(clienteVO.getNombreCliente().concat(" ").concat(clienteVO.getApellidoPaternoCliente().concat(" ").concat(clienteVO.getApellidoMaternoCliente())));
            target.setEstado(Constantes.ACTIVO);
            tarjetaRepository.persist(target);
            respuesta.put(Constantes.MENSAJE, Constantes.MENSAJE_PROCESO_EXITOSO);
            respuesta.put(Constantes.DATA, target);
        } else {
            respuesta.put(Constantes.ERROR, Constantes.ERROR_NO_EXISTE_CLIENTE.replace("{numdoc}", request.getNumeroDocumento()));
        }
        return respuesta;
    }


    @Override
    @Transactional
    public Map<String, Object> deleteTarger(Long id) {
        Map<String, Object> rsp = new HashMap<>();
        Tarjeta tarjeta = tarjetaRepository.findByIdOptional(Long.valueOf(id)).orElse(null);
        if (Objects.nonNull(tarjeta)) {
            tarjeta.setEstado(Constantes.ELIMINADO);
            tarjetaRepository.persist(tarjeta);
            rsp.put(Constantes.MENSAJE, Constantes.MENSAJE_PROCESO_EXITOSO);
        } else {
            rsp.put(Constantes.ERROR, Constantes.ERROR_NO_EXISTE_INFORMACION);
        }

        return rsp;
    }

    @Override
    @Transactional
    public Map<String, Object> updateTarget(Tarjeta target) {
        Map<String, Object> rsp = new HashMap<>();
        Tarjeta objTarjeta = tarjetaRepository.findByIdOptional(target.getIdTarjeta()).orElse(null);
        if (Objects.nonNull(objTarjeta)) {
            objTarjeta.setNumTarjeta(target.getNumTarjeta());
            objTarjeta.setPinTarjeta(target.getPinTarjeta());
            objTarjeta.setTipTarjeta(target.getTipTarjeta());
            objTarjeta.setFecVenc(target.getFecVenc());
            objTarjeta.setCodValTarj(target.getCodValTarj());
            objTarjeta.setFecCorte(Objects.isNull(target.getFecCorte()) ? null : target.getFecCorte());
            objTarjeta.setFecLimPagMens(Objects.isNull(target.getFecLimPagMens()) ? null : target.getFecLimPagMens());
            objTarjeta.setSalActu(target.getSalActu());
            objTarjeta.setLimCred(Objects.isNull(target.getLimCred()) ? null : target.getLimCred());
            objTarjeta.setCuentBanc(target.getCuentBanc());
            objTarjeta.setNumDocCli(target.getNumDocCli());
            objTarjeta.setCliente(target.getCliente());
            tarjetaRepository.persist(objTarjeta);
            rsp.put(Constantes.MENSAJE, Constantes.MENSAJE_PROCESO_EXITOSO);
            rsp.put(Constantes.DATA, target);
        } else {
            rsp.put(Constantes.ERROR, Constantes.ERROR_NO_EXISTE_INFORMACION);
        }
        return rsp;
    }

    @Override
    public List<Tarjeta> findAll() {
        return tarjetaRepository.findAll().list();
    }

    @Override
    public List<Tarjeta> findAllByActivos() {
        return tarjetaRepository.findAll().list().stream().filter(tr -> Constantes.ACTIVO.equals(tr.getEstado())).toList();
    }


}
