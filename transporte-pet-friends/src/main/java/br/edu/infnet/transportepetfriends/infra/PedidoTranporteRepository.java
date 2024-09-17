package br.edu.infnet.transportepetfriends.infra;

import br.edu.infnet.transportepetfriends.domain.PedidoTransporte;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoTranporteRepository extends MongoRepository<PedidoTransporte, String> {
}
