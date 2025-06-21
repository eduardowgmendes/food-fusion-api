package br.com.edu.foodfusion.shared.dto.inventory;

import br.com.edu.foodfusion.shared.database.entity.inventory.goods.GoodsEntity;
import br.com.edu.foodfusion.shared.database.enums.GoodsCategoryEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("maker")
    private String maker;

    @JsonProperty("model")
    private String model;

    @JsonProperty("unit_price")
    private BigDecimal unitPrice;

    @JsonProperty("gross_weight")
    private BigDecimal grossWeight;

    @JsonProperty("net_weight")
    private BigDecimal netWeight;

    @JsonProperty("ean_8")
    private String EAN_8;

    @JsonProperty("ean_13")
    private String EAN_13;

    @JsonProperty("ean_14")
    private String EAN_14;

    @JsonProperty("ean_128")
    private String EAN_128;

    @JsonProperty("sku")
    private String SKU;

    @JsonProperty("upc")
    private String UPC;

    @JsonProperty("upc_a")
    private String UPC_A;

    @JsonProperty("upc_e")
    private String UPC_E;

    @JsonProperty("gtin")
    private String GTIN;

    @JsonProperty("ncm")
    private String NCM;

    @JsonProperty("barcode")
    private String barcode;

    @JsonProperty("patents")
    private List<String> patents;

    @JsonProperty("certifications")
    private List<String> certifications;

    @JsonProperty("technical_specs")
    private String technicalSpecs;

    @JsonProperty("ingredients")
    private String ingredients;

    @JsonProperty("category")
    private GoodsCategoryEnum category;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("deleted_at")
    private LocalDateTime deletedAt;

    @JsonProperty("deleted")
    private boolean deleted;

    public static GoodsEntity toEntity(GoodsDTO goodsDTO) {
        return new ModelMapper()
                .map(goodsDTO, GoodsEntity.class);
    }

}
