package jss.ecommerce.api.service;

import jss.ecommerce.api.entity.Lote;
import jss.ecommerce.api.entity.Pedido;
import jss.ecommerce.api.repository.LoteRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
public class LoteService {

    private final LoteRepository loteRepository;

    public LoteService(LoteRepository loteRepository) {
        this.loteRepository = loteRepository;
    }

    public void retirarProduto(Pedido pedido) {
        final Lote lote = loteRepository.buscarLotesDisponiveis(pedido.getProduto().getId())
                .stream()
                .findAny()
                .orElseThrow(() -> new NoResultException("Não foi encontrado lote algum para retirada de produto"));

        lote.getQuantidade().subtract(pedido.getQuantidade());

        loteRepository.save(lote);
    }
}
