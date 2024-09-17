package br.edu.infnet.transportepetfriends.domain.payload;

import br.edu.infnet.transportepetfriends.domain.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoPedidoPayload {
    private String pedidoId;
    private EstadoPedido estado;
}
