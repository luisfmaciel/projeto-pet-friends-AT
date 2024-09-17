package br.edu.infnet.almoxarifadopetfriends.service.feign;

import br.edu.infnet.almoxarifadopetfriends.domain.EstadoPedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("TRANSPORTE-SERVICE")
public interface TransporteClient {
    @PostMapping
    EstadoPedido enviarPedidoTransporte(@RequestBody String pedidoId);
}