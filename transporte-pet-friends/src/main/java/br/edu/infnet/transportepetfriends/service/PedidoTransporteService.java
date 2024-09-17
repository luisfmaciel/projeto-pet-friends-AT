package br.edu.infnet.transportepetfriends.service;

import br.edu.infnet.transportepetfriends.domain.PedidoTransporte;
import br.edu.infnet.transportepetfriends.domain.payload.EstadoPedidoPayload;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PedidoTransporteService {
    PedidoTransporte registrarPedido(PedidoTransporte pedidoTransporte);
    EstadoPedidoPayload atualizarEstadoPedido(EstadoPedidoPayload estadoPedidoPayload);
    void processaPedido(String pedidoId) throws JsonProcessingException;

}
