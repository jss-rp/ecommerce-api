package jss.ecommerce.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CIDADES")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    @ManyToOne
    @JoinColumn(columnDefinition = "uf_id")
    private UF uf;
}
