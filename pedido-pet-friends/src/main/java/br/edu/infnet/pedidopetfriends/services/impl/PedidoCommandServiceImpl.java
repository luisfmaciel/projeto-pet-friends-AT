package br.edu.infnet.pedidopetfriends.services.impl;

import br.edu.infnet.pedidopetfriends.commands.*;
import br.edu.infnet.pedidopetfriends.domain.EstadoPedido;
import br.edu.infnet.pedidopetfriends.domain.Pedido;
import br.edu.infnet.pedidopetfriends.services.PedidoCommandService;
import br.edu.infnet.pedidopetfriends.services.feign.AlmoxarifadoClient;
import br.edu.infnet.pedidopetfriends.services.feign.TransporteClient;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class PedidoCommandServiceImpl implements PedidoCommandService {

    private final CommandGateway commandGateway;
    private final AlmoxarifadoClient almoxarifadoClient;
    private final TransporteClient transporteClient;

    @Override
    public CompletableFuture<String> criarPedido(Pedido pedido) {
        return commandGateway.send(new CriarPedidoCommand(
                UUID.randomUUID().toString(),
                pedido.getClienteId(),
                pedido.getProdutosId(),
                pedido.getTotal()));
    }

    @Override
    public CompletableFuture<String> adicionarProduto(String id, String produtoId, double valor) {
        return commandGateway.send(new AdicionarProdutoCommand(id, produtoId, valor));
    }

    @Override
    public CompletableFuture<String> cancelarPedido(String id) {
        return commandGateway.send(new CancelarPedidoCommand(id));
    }

    @Override
    public CompletableFuture<String> enviarPedidoAlmoxarifado(String pedidoId) {
        EstadoPedido estado = almoxarifadoClient.enviarPedidoAlmoxarifado(pedidoId);
        return commandGateway.send(new AtualizaPedidoCommand(pedidoId, estado));
    }

    @Override
    public CompletableFuture<String> despacharPedido(String pedidoId) {
        EstadoPedido estado = transporteClient.despacharPedido(pedidoId);
        return commandGateway.send(new AtualizaPedidoCommand(pedidoId, estado));
    }

    @Override
    public CompletableFuture<String> atualizarEstadoPedido(String pedidoId, EstadoPedido estado) {
        return commandGateway.send(new AtualizaPedidoCommand(pedidoId, estado));
    }
}
