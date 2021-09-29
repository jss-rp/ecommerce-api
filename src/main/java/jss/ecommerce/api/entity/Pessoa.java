package jss.ecommerce.api.entity;

import jss.ecommerce.api.util.LocalidadeToJSONConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpf;

    private String nome;

    private String sobrenome;

    private String email;

    private LocalDate dataNascimento;

    @Column(columnDefinition = "json")
    @Convert(converter = LocalidadeToJSONConverter.class)
    private Localidade endereco;
}
