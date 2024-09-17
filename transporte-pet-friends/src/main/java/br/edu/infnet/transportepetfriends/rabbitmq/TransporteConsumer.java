package br.edu.infnet.transportepetfriends.rabbitmq;


import br.edu.infnet.transportepetfriends.service.impl.PedidoTransporteServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransporteConsumer {

    private final PedidoTransporteServiceImpl pedidoTransporteService;

    @RabbitListener(queues = {"transporte-queue"})
    public void recebePedido(@Payload String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String pedidoId = mapper.readValue(message, String.class);

        pedidoTransporteService.processaPedido(pedidoId);
    }
}
