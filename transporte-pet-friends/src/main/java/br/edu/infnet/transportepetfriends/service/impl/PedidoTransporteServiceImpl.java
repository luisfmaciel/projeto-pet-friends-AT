package br.edu.infnet.transportepetfriends.service.impl;

import br.edu.infnet.transportepetfriends.domain.EstadoPedido;
import br.edu.infnet.transportepetfriends.domain.PedidoTransporte;
import br.edu.infnet.transportepetfriends.domain.payload.EstadoPedidoPayload;
import br.edu.infnet.transportepetfriends.infra.PedidoTranporteRepository;
import br.edu.infnet.transportepetfriends.rabbitmq.TransporteProducer;
import br.edu.infnet.transportepetfriends.service.PedidoTransporteService;
import br.edu.infnet.transportepetfriends.service.feign.PedidoClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoTransporteServiceImpl implements PedidoTransporteService {

    private final PedidoClient pedidoClient;
    private final PedidoTranporteRepository pedidoTranporteRepository;
    private final TransporteProducer transporteProducer;

    @Override
    public EstadoPedidoPayload atualizarEstadoPedido(EstadoPedidoPayload payload) {
        return pedidoClient.atualizarEstadoPedido(payload);
    }

    @Override
    public PedidoTransporte registrarPedido(PedidoTransporte pedidoTransporte) {
        return pedidoTranporteRepository.save(pedidoTransporte);
    }

    @Override
    public void processaPedido(String pedidoId) throws JsonProcessingException {
        PedidoTransporte pedidoTransporte = new PedidoTransporte();
        pedidoTransporte.setPedidoId(pedidoId);
        pedidoTranporteRepository.save(pedidoTransporte);
        EstadoPedidoPayload estadoPedidoPayload = new EstadoPedidoPayload(pedidoId, EstadoPedido.EM_TRANSITO);
        transporteProducer.atualizarEstadoPedido(estadoPedidoPayload);
    }
}
