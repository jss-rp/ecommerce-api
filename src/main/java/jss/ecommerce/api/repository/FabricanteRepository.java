package jss.ecommerce.api.repository;

import jss.ecommerce.api.entity.Fabricante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface FabricanteRepository extends CrudRepository<Fabricante, Long> {
}
