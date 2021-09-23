package jss.ecommerce.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "LOTES")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(columnDefinition = "produto_id")
    private Produto produto;

    private LocalDate dataFabricao;
    private LocalDate validade;

    @ManyToOne
    @JoinColumn(columnDefinition = "fabrica_id")
    private Fabrica fabrica;

    private BigInteger quantidade;
}
