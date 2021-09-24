package jss.ecommerce.api.repository;

import jss.ecommerce.api.entity.Lote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends CrudRepository<Lote, Long> {
}
