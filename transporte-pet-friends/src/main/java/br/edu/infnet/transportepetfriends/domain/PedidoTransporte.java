package br.edu.infnet.transportepetfriends.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
public class PedidoTransporte {
    @Id
    @AggregateIdentifier
    private Long id;
    private String pedidoId;
    private String destinatarioId;
    private String descricao;
    private Date dataPedido;
    private Date dataEntrega;
    private Endereco enderecoOrigem;
    private Endereco enderecoDestino;
    private String codigoRastreio;
}
