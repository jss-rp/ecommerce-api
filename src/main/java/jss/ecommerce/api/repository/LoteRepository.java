package jss.ecommerce.api.repository;

import jss.ecommerce.api.entity.Lote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LoteRepository extends CrudRepository<Lote, Long> {

    @Query(value = "SELECT MAX(l.validade) FROM lotes l WHERE l.quantidade > 0 AND l.produto_id = :produtoId", nativeQuery = true)
    Collection<Lote> buscarLotesDisponiveis(@Param("produtoId") Long produtoId);
}
