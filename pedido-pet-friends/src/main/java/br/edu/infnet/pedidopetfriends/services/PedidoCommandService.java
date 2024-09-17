package br.edu.infnet.pedidopetfriends.services;

import br.edu.infnet.pedidopetfriends.domain.EstadoPedido;
import br.edu.infnet.pedidopetfriends.domain.Pedido;

import java.util.concurrent.CompletableFuture;

public interface PedidoCommandService {
    CompletableFuture<String> criarPedido(Pedido pedido);
    CompletableFuture<String> adicionarProduto(String id, String produtoId, double valor);
    CompletableFuture<String> cancelarPedido(String id);
    CompletableFuture<String> enviarPedidoAlmoxarifado(String produtoId);
    CompletableFuture<String> atualizarEstadoPedido(String produtoId, EstadoPedido estado);
    CompletableFuture<String> despacharPedido(String pedidoId);
}