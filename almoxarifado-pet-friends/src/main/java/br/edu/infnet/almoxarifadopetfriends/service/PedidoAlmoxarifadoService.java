package br.edu.infnet.almoxarifadopetfriends.service;

import br.edu.infnet.almoxarifadopetfriends.domain.EstadoPedido;
import br.edu.infnet.almoxarifadopetfriends.domain.PedidoAlmoxarifado;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PedidoAlmoxarifadoService {
    EstadoPedido enviarPedidoTransporte(String pedidoId);
    PedidoAlmoxarifado registrarPedido(PedidoAlmoxarifado pedidoAlmoxarifado);
    void processaPedido(String pedidoId) throws JsonProcessingException;
}
