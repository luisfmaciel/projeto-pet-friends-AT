package br.edu.infnet.almoxarifadopetfriends.service.impl;

import br.edu.infnet.almoxarifadopetfriends.domain.Dimensoes;
import br.edu.infnet.almoxarifadopetfriends.domain.EstadoPedido;
import br.edu.infnet.almoxarifadopetfriends.domain.PedidoAlmoxarifado;
import br.edu.infnet.almoxarifadopetfriends.domain.payload.EstadoPedidoPayload;
import br.edu.infnet.almoxarifadopetfriends.infra.PedidoAlmoxarifadoRepository;
import br.edu.infnet.almoxarifadopetfriends.rabbitmq.AlmoxarifadoProducer;
import br.edu.infnet.almoxarifadopetfriends.service.PedidoAlmoxarifadoService;
import br.edu.infnet.almoxarifadopetfriends.service.feign.TransporteClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoAlmoxarifadoServiceImpl implements PedidoAlmoxarifadoService {

    private final TransporteClient transporteClient;
    private final PedidoAlmoxarifadoRepository almoxarifadoRepository;
    private final AlmoxarifadoProducer almoxarifadoProducer;

    @Override
    public EstadoPedido enviarPedidoTransporte(String pedidoId) {
        return transporteClient.enviarPedidoTransporte(pedidoId);
    }

    @Override
    public PedidoAlmoxarifado registrarPedido(PedidoAlmoxarifado pedidoAlmoxarifado) {
        return almoxarifadoRepository.save(pedidoAlmoxarifado);
    }

    @Override
    public void processaPedido(String pedidoId) throws JsonProcessingException {
        Dimensoes dimensoes = new Dimensoes();
        // Buscar informações do pedido.
        PedidoAlmoxarifado pedidoAlmoxarifado = new PedidoAlmoxarifado();
        pedidoAlmoxarifado.setPedidoId(pedidoId);
        pedidoAlmoxarifado.setDimensoes(dimensoes);
        almoxarifadoRepository.save(pedidoAlmoxarifado);
        EstadoPedidoPayload estadoPedidoPayload = new EstadoPedidoPayload(pedidoId, EstadoPedido.EM_PREPARACAO);
        almoxarifadoProducer.atualizarEstadoPedido(estadoPedidoPayload);
    }
}
