package br.com.edu.foodfusion.shared.request;

import br.com.edu.foodfusion.shared.dto.inventory.GoodsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGoodsRequest {

    private long goodsId;
    private GoodsDTO goods;

}
