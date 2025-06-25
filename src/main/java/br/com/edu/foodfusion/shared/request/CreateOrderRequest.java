package br.com.edu.foodfusion.shared.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CreateOrderRequest {

    @NotNull(message = "Establishment id is required.")
    private long establishmentId;

    @NotNull(message = "Customer id is required.")
    private long customerId;

    @NotNull(message = "Items ids is required.")
    @NotEmpty(message = "At least one item must be present.")
    private List<Long> itemIds;

}
