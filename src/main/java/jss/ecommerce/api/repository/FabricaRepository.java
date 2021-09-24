package jss.ecommerce.api.repository;

import jss.ecommerce.api.entity.Fabrica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricaRepository extends CrudRepository<Fabrica, Long> {
}
