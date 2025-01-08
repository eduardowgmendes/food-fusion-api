package br.com.edu.foodfusion.shared.dto.restaurant;

import br.com.edu.foodfusion.shared.database.entity.ServiceTimeEntity;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ServiceTimeDTO {

    private String name;
    private LocalTime opensAt;
    private LocalTime closesAt;

    public static ServiceTimeEntity toServiceTimeEntity(ServiceTimeDTO serviceTimeDTO) {
        return new ModelMapper()
                .map(serviceTimeDTO, ServiceTimeEntity.class);
    }
}
