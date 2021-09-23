package jss.ecommerce.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "UFS")
public class UF {

    @Id
    @Column(length = 2)
    private String codigo;

    private String nome;
}
