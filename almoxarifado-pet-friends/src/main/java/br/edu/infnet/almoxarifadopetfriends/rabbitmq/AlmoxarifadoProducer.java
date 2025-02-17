package br.edu.infnet.almoxarifadopetfriends.rabbitmq;

import br.edu.infnet.almoxarifadopetfriends.domain.payload.EstadoPedidoPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlmoxarifadoProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;
    public void atualizarEstadoPedido(EstadoPedidoPayload payload) throws JsonProcessingException {
        amqpTemplate.convertAndSend("pedido-exc", "pedido-rk", objectMapper.writeValueAsString(payload));
    }
}
