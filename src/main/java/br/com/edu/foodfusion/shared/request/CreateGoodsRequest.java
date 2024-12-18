package br.com.edu.foodfusion.shared.request;

import br.com.edu.foodfusion.shared.dto.inventory.GoodsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateGoodsRequest {
    private GoodsDTO newGoods;
}
