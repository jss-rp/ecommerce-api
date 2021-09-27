package jss.ecommerce.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class PedidoStatus {

    public enum Status {
        AGR1, // AGUARDANDO CONFIRMACAO
        CFD2, // CONFIRMADO
        AEQ3, // AGUARDANDO LIBERACAO DO ESTOQUE
        ADC4, // AGUARDANDO DESPACHO
        PDP5, // PRODUTO DESPACHADO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime inicio;

    private LocalDateTime fim;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private String statusNome;
}
