package jss.ecommerce.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
@Entity
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @ManyToOne
    @JoinColumn(columnDefinition = "produto_id")
    private Produto produto;

    @JsonProperty("data_fabricacao")
    private LocalDate dataFabricao;
    private LocalDate validade;

    @ManyToOne
    @JoinColumn(columnDefinition = "fabrica_id")
    private Fabrica fabrica;

    private BigInteger quantidade;
}
