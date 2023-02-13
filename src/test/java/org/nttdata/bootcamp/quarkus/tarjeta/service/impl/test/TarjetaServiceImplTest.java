package org.nttdata.bootcamp.quarkus.tarjeta.service.impl.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.nttdata.bootcamp.quarkus.tarjeta.repository.TarjetaRepository;
import org.nttdata.bootcamp.quarkus.tarjeta.service.impl.TarjetaServiceImpl;
import org.nttdata.bootcamp.quarkus.tarjeta.util.Constantes;
import org.nttdata.bootcamp.quarkus.tarjeta.ws.client.ClienteCallClient;
import org.nttdata.bootcamp.quarkus.tarjeta.ws.vo.ClienteVO;
import org.nttdata.bootcamp.quarkus.tarjeta.ws.vo.TarjetaVO;

import java.util.HashMap;
import java.util.Map;

public class TarjetaServiceImplTest {

    @InjectMocks
    TarjetaServiceImpl service;
    @Mock
    TarjetaRepository tarjetaRepository;
    @Mock
    ClienteCallClient clienteCallClient;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createTargetTest() {
        TarjetaVO request = new TarjetaVO();
        request.setPinTarjeta("123");
        request.setNumeroDocumento("123456789");
        Map<String, Object> respuesta = new HashMap<>();
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setNombreCliente("PEDRO");
        clienteVO.setApellidoPaternoCliente("APELLIDO");
        clienteVO.setApellidoMaternoCliente("APELLIDO MATERNO");
        respuesta.put(Constantes.MENSAJE, Constantes.MENSAJE_PROCESO_EXITOSO);

        Mockito.when(clienteCallClient.buscarClientePorDocumento(Mockito.anyString())).thenReturn(clienteVO);
        Assertions.assertEquals(service.createTarget(request).get(Constantes.MENSAJE), respuesta.get(Constantes.MENSAJE));
    }

    @Test
    public void createTargetErrorTest() {
        TarjetaVO request = new TarjetaVO();
        request.setPinTarjeta("123");
        request.setNumeroDocumento("123456789");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put(Constantes.ERROR, Constantes.ERROR_NO_EXISTE_CLIENTE.replace("{numdoc}", request.getNumeroDocumento()));

        Mockito.when(clienteCallClient.buscarClientePorDocumento(Mockito.anyString())).thenReturn(null);
        Assertions.assertEquals(service.createTarget(request).get(Constantes.ERROR), respuesta.get(Constantes.ERROR));
    }
}
