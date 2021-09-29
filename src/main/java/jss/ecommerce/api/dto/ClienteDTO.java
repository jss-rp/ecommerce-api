package jss.ecommerce.api.dto;

import jss.ecommerce.api.entity.Cliente;
import jss.ecommerce.api.entity.Pessoa;

public class ClienteDTO {

    private Long id;

    private Pessoa pessoa;

    public ClienteDTO(Cliente cliente) {
        id = cliente.getId();
        pessoa = cliente.getPessoa();
    }
}
