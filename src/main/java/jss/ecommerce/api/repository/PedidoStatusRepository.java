package jss.ecommerce.api.repository;

import jss.ecommerce.api.entity.PedidoStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoStatusRepository extends CrudRepository<PedidoStatus, Long> {
}
