package br.com.edu.foodfusion.shared.dto.inventory;

import br.com.edu.foodfusion.shared.database.entity.inventory.goods.GoodsEntity;
import br.com.edu.foodfusion.shared.database.enums.GoodsCategoryEnum;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class GoodsDTO {

    private long id;

    private String name;

    private String description;

    private String maker;

    private String model;

    private BigDecimal unitPrice;

    private BigDecimal grossWeight;

    private BigDecimal netWeight;

    private String EAN_8;

    private String EAN_13;

    private String EAN_14;

    private String EAN_128;

    private String SKU;

    private String UPC;

    private String UPC_A;

    private String UPC_E;

    private String GTIN;

    private String NCM;

    private String barcode;

    private List<String> patents;

    private List<String> certifications;

    private String technicalSpecs;

    private String ingredients;

    private GoodsCategoryEnum category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private boolean deleted;

    public static GoodsEntity toEntity(GoodsDTO goodsDTO) {
        return new ModelMapper()
                .map(goodsDTO, GoodsEntity.class);
    }

}
