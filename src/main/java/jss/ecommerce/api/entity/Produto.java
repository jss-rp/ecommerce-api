package jss.ecommerce.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(columnDefinition = "fabricante_id")
    private Fabricante fabricante;

    @OneToMany(mappedBy = "produto")
    private List<Lote> lotes;


}
