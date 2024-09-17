package br.edu.infnet.pedidopetfriends.events;

import br.edu.infnet.pedidopetfriends.domain.EstadoPedido;

public class AtualizaEstadoPedido extends BaseEvent<String> {
    public final EstadoPedido estado;

    public AtualizaEstadoPedido(String pedidoId, EstadoPedido estado) {
        super(pedidoId);
        this.estado = estado;
    }
}