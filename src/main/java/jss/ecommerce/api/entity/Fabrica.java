package jss.ecommerce.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "FABRICAS")
public class Fabrica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(columnDefinition = "fabricante_id")
    private Fabricante fabricante;

    @ManyToOne
    @JoinColumn(columnDefinition = "cidade_id")
    private Cidade cidade;

    private String cep;
    private String logradouro;
    private String complemento;
}
