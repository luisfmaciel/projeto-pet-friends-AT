package br.edu.infnet.pedidopetfriends.services.feign;

import br.edu.infnet.pedidopetfriends.domain.EstadoPedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("ALMOXARIFADO-SERVICE")
public interface AlmoxarifadoClient {
    @PostMapping
    EstadoPedido enviarPedidoAlmoxarifado(@RequestBody String pedidoId);
}

