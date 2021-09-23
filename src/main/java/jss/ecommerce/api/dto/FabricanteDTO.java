package jss.ecommerce.api.dto;

import jss.ecommerce.api.entity.Fabricante;
import lombok.Data;

@Data
public class FabricanteDTO {

    private Long id;
    private String nome;

    public FabricanteDTO(Fabricante fabricante) {
        id = fabricante.getId();
        nome = fabricante.getNome();
    }
}
