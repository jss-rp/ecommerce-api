package jss.ecommerce.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jss.ecommerce.api.entity.Produto;
import lombok.Data;

@Data
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String sku;

    @JsonProperty("fabricante_id")
    private Long fabricanteId;

    private Integer quantidade;

    public ProdutoDTO(Produto produto) {
        id = produto.getId();
        nome = produto.getNome();
        fabricanteId = produto.getFabricante().getId();
        sku = produto.getSku();
    }
}
