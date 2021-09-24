package jss.ecommerce.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jss.ecommerce.api.entity.Fabrica;
import jss.ecommerce.api.entity.Fabricante;
import jss.ecommerce.api.entity.Localidade;
import lombok.Data;

@Data
public class FabricaDTO {

    private Long id;

    @JsonProperty("fabricante_id")
    private Long fabricanteId;

    private Localidade localidade;

    public FabricaDTO(Fabrica fabrica) {
        id = fabrica.getId();
        fabricanteId = fabrica.getFabricante().getId();
        localidade = fabrica.getLocalidade();
    }
}
