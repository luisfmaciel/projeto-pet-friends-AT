package br.edu.infnet.almoxarifadopetfriends.infra;

import br.edu.infnet.almoxarifadopetfriends.domain.PedidoAlmoxarifado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoAlmoxarifadoRepository extends MongoRepository<PedidoAlmoxarifado, String> {
}
