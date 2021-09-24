package jss.ecommerce.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Localidade {

    private String cep;
    private String logradouro;
    private String complemento;
    private String cidade;
    private String uf;
}
