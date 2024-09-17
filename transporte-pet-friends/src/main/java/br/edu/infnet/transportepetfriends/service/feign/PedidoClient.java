package br.edu.infnet.transportepetfriends.service.feign;

import br.edu.infnet.transportepetfriends.domain.payload.EstadoPedidoPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PEDIDO-SERVICE")
public interface PedidoClient {
    @PutMapping("/atualiza-estado")
    EstadoPedidoPayload atualizarEstadoPedido(@RequestBody EstadoPedidoPayload payload);
}