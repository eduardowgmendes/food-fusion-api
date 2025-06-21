package br.com.edu.foodfusion.shared.request;

import br.com.edu.foodfusion.shared.dto.inventory.GoodsDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateGoodsRequest {
    @JsonProperty("new_goods")
    private GoodsDTO newGoods;
}
