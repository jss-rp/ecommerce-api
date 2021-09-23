package jss.ecommerce.api.service;

import jss.ecommerce.api.entity.Produto;
import jss.ecommerce.api.repository.ProdutoRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Integer contarProdutos(Long produtoId) {
        final Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(RuntimeException::new);

        Hibernate.initialize(produto.getLotes());

        return produto.getLotes()
                .stream()
                .mapToInt(lote -> lote.getQuantidade().intValue())
                .sum();
    }
}
