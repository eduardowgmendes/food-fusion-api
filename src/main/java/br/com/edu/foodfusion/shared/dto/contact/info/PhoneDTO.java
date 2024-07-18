package br.com.edu.foodfusion.shared.dto.contact.info;

import br.com.edu.foodfusion.shared.database.entity.contact.info.PhoneEntity;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PhoneDTO {
    private String prefix;
    private String phoneNumber;

    public static PhoneEntity toPhoneEntity(PhoneDTO phoneDTO) {
        return new ModelMapper()
                .map(phoneDTO, PhoneEntity.class);
    }
}
