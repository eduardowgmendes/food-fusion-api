package br.com.edu.foodfusion.shared.dto.contact.info.email;

import br.com.edu.foodfusion.shared.database.entity.contact.email.EmailEntity;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmailDTO {

    private long id;
    private String email;

    public static EmailEntity toEmailEntity(EmailDTO emailDTO) {
        return new ModelMapper()
                .map(emailDTO, EmailEntity.class);
    }
}
