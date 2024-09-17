package br.edu.infnet.transportepetfriends.controller;

import br.edu.infnet.transportepetfriends.domain.EstadoPedido;
import br.edu.infnet.transportepetfriends.domain.PedidoTransporte;
import br.edu.infnet.transportepetfriends.domain.payload.EstadoPedidoPayload;
import br.edu.infnet.transportepetfriends.service.impl.PedidoTransporteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/almoxarifado")
public class PedidoTransporteController {

    @Autowired
    private PedidoTransporteServiceImpl pedidoTransporteService;

    @PostMapping
    public EstadoPedido recebePedido(@RequestBody String pedidoId) {
        PedidoTransporte pedidoTransporte = new PedidoTransporte();
        pedidoTransporte.setPedidoId(pedidoId);
        pedidoTransporteService.registrarPedido(pedidoTransporte);
        EstadoPedidoPayload payload = new EstadoPedidoPayload(pedidoId, EstadoPedido.EM_TRANSITO);
        pedidoTransporteService.atualizarEstadoPedido(payload);
        return EstadoPedido.EM_TRANSITO;
    }
}

