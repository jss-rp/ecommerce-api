package jss.ecommerce.api.entity;

import jss.ecommerce.api.util.LocalidadeToJSONConverter;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Fabrica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(columnDefinition = "fabricante_id")
    private Fabricante fabricante;

    @Column(columnDefinition = "json")
    @Convert(converter = LocalidadeToJSONConverter.class)
    private Localidade localidade;
}
