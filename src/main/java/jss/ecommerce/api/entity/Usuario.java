package jss.ecommerce.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    @JsonProperty("nome_usuario")
    public String nomeUsuario;

    public String senha;

    public LocalDateTime dataCriacao;

    public LocalDateTime ultimoLogin;
}
