package br.edu.infnet.almoxarifadopetfriends.controller;

import br.edu.infnet.almoxarifadopetfriends.domain.Dimensoes;
import br.edu.infnet.almoxarifadopetfriends.domain.EstadoPedido;
import br.edu.infnet.almoxarifadopetfriends.domain.PedidoAlmoxarifado;
import br.edu.infnet.almoxarifadopetfriends.service.impl.PedidoAlmoxarifadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/almoxarifado")
public class PedidoAlmoxarifadoController {

    @Autowired
    private PedidoAlmoxarifadoServiceImpl pedidoAlmoxarifadoService;

    @PostMapping
    public EstadoPedido recebePedido(@RequestBody String pedidoId) {
        Dimensoes dimensoes= new Dimensoes(20, 20, 20);
        PedidoAlmoxarifado pedidoAlmoxarifado = new PedidoAlmoxarifado();
        pedidoAlmoxarifado.setPedidoId(pedidoId);
        pedidoAlmoxarifado.setDimensoes(dimensoes);
        pedidoAlmoxarifadoService.registrarPedido(pedidoAlmoxarifado);
        pedidoAlmoxarifadoService.enviarPedidoTransporte(pedidoId);
        return EstadoPedido.EM_PREPARACAO;
    }
}
