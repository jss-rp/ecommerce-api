package jss.ecommerce.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
