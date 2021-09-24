package jss.ecommerce.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "fabricante", fetch = FetchType.LAZY)
    private List<Produto> produtos;

    @OneToMany(mappedBy = "fabricante", fetch = FetchType.LAZY)
    private List<Fabrica> fabricas;
}
