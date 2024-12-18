package br.com.edu.foodfusion.shared.request;

import br.com.edu.foodfusion.shared.dto.restaurant.MenuDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMenuRequest {

    private long restaurantId;
    private MenuDTO menu;
}
