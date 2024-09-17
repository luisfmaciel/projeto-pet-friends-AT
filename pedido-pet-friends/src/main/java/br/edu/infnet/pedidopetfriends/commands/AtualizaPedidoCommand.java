package br.edu.infnet.pedidopetfriends.commands;

import br.edu.infnet.pedidopetfriends.domain.EstadoPedido;

public class AtualizaPedidoCommand extends BaseCommand<String> {
    public final EstadoPedido estado;

    public AtualizaPedidoCommand(String id, EstadoPedido estado) {
        super(id);
        this.estado = estado;
    }
}