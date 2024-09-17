package br.edu.infnet.almoxarifadopetfriends.rabbitmq;

import br.edu.infnet.almoxarifadopetfriends.service.impl.PedidoAlmoxarifadoServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlmoxarifadoConsumer {

    private final PedidoAlmoxarifadoServiceImpl pedidoAlmoxarifadoService;

    @RabbitListener(queues = {"almoxarifado-queue"})
    public void recebePedido(@Payload String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String pedidoId = mapper.readValue(message, String.class);

        pedidoAlmoxarifadoService.processaPedido(pedidoId);
    }
}
