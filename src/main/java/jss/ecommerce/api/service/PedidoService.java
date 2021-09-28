package jss.ecommerce.api.service;

import jss.ecommerce.api.entity.Pedido;
import jss.ecommerce.api.entity.PedidoStatus;
import jss.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    private final LoteService loteService;

    public PedidoService(PedidoRepository pedidoRepository, LoteService loteService) {
        this.pedidoRepository = pedidoRepository;
        this.loteService = loteService;
    }

    @Transactional
    public void mudarStatus(Long produtoId, PedidoStatus pedidoStatus) {
        final Pedido pedido = pedidoRepository.findById(produtoId)
                .orElseThrow(() -> new NoResultException("Pedido não encontrado"));

        final PedidoStatus.Status status = pedidoStatus.getStatus();

        if(status.equals(PedidoStatus.Status.ADC4)) {
            loteService.retirarProduto(pedido);
        }

        pedido.setStatus(pedidoStatus);
        pedidoRepository.save(pedido);
    }


}
