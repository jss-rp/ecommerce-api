package jss.ecommerce.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jss.ecommerce.api.entity.Lote;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class LoteDTO {

    private Long codigo;

    @JsonProperty("produto_id")
    private Long produtoId;

    @JsonProperty("data_fabricacao")
    private LocalDate dataFabricacao;

    private LocalDate validade;

    @JsonProperty("fabrica_id")
    private Long fabricaId;

    private BigInteger quantidade;

    public LoteDTO(Lote lote) {
        codigo = lote.getCodigo();
        produtoId = lote.getProduto().getId();
        dataFabricacao = lote.getDataFabricao();
        validade = lote.getValidade();
        fabricaId = lote.getFabrica().getId();
        quantidade = lote.getQuantidade();
    }
}
