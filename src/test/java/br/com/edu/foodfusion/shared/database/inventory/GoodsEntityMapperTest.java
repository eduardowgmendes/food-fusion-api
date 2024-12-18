package br.com.edu.foodfusion.shared.database.inventory;

import br.com.edu.foodfusion.shared.database.builder.entity.GoodsEntityBuilder;
import br.com.edu.foodfusion.shared.database.entity.inventory.goods.GoodsEntity;
import br.com.edu.foodfusion.shared.dto.inventory.GoodsDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GoodsEntityMapperTest {

    @Test
    public void mappingOfGoodsEntityToGoodsDTOIsSuccessfullyApplied() {
        GoodsEntity goodsEntity = provideEntity();
        GoodsDTO goodsDTO = GoodsEntity.toDTO(goodsEntity);

        assertThat(goodsDTO).isNotNull();
        assertThat(goodsDTO.getId()).isEqualTo(goodsEntity.getId());
        assertThat(goodsDTO.getName()).isEqualTo(goodsEntity.getName());
        assertThat(goodsDTO.getMaker()).isEqualTo(goodsEntity.getMaker());
        assertThat(goodsDTO.getModel()).isEqualTo(goodsEntity.getModel());
        assertThat(goodsDTO.getNetWeight()).isEqualTo(goodsEntity.getNetWeight());
        assertThat(goodsDTO.getGrossWeight()).isEqualTo(goodsEntity.getGrossWeight());
        assertThat(goodsDTO.getTechnicalSpecs()).isEqualTo(goodsEntity.getTechnicalSpecs());
        assertThat(goodsDTO.getPatents()).isEqualTo(goodsEntity.getPatents());
        assertThat(goodsDTO.getIngredients()).isEqualTo(goodsEntity.getIngredients());
        assertThat(goodsDTO.getGTIN()).isEqualTo(goodsEntity.getGTIN());
        assertThat(goodsDTO.getGTIN()).isEqualTo(goodsEntity.getGTIN());
        assertThat(goodsDTO.getEAN_8()).isEqualTo(goodsEntity.getEAN_8());
        assertThat(goodsDTO.getEAN_13()).isEqualTo(goodsEntity.getEAN_13());
        assertThat(goodsDTO.getEAN_14()).isEqualTo(goodsEntity.getEAN_14());
        assertThat(goodsDTO.getEAN_128()).isEqualTo(goodsEntity.getEAN_128());
        assertThat(goodsDTO.getUPC()).isEqualTo(goodsEntity.getUPC());
        assertThat(goodsDTO.getUPC_A()).isEqualTo(goodsEntity.getUPC_A());
        assertThat(goodsDTO.getUPC_E()).isEqualTo(goodsEntity.getUPC_E());
        assertThat(goodsDTO.getBarcode()).isEqualTo(goodsEntity.getBarcode());
        assertThat(goodsDTO.getSKU()).isEqualTo(goodsEntity.getSKU());
        assertThat(goodsDTO.getUnitPrice()).isEqualTo(goodsEntity.getUnitPrice());
        assertThat(goodsDTO.getCreatedAt()).isEqualTo(goodsEntity.getCreatedAt());
    }

    @Test
    public void mappingOfGoodsDTOToGoodsEntityIsSuccessfullyApplied() {
        GoodsDTO goodsDTO = provideDTO();
        GoodsEntity goodsEntity = GoodsDTO.toEntity(goodsDTO);

        assertThat(goodsEntity).isNotNull();
        assertThat(goodsEntity.getId()).isEqualTo(goodsDTO.getId());
        assertThat(goodsEntity.getName()).isEqualTo(goodsDTO.getName());
        assertThat(goodsEntity.getMaker()).isEqualTo(goodsDTO.getMaker());
        assertThat(goodsEntity.getModel()).isEqualTo(goodsDTO.getModel());
        assertThat(goodsEntity.getNetWeight()).isEqualTo(goodsDTO.getNetWeight());
        assertThat(goodsEntity.getGrossWeight()).isEqualTo(goodsDTO.getGrossWeight());
        assertThat(goodsEntity.getTechnicalSpecs()).isEqualTo(goodsDTO.getTechnicalSpecs());
        assertThat(goodsEntity.getPatents()).isEqualTo(goodsDTO.getPatents());
        assertThat(goodsEntity.getIngredients()).isEqualTo(goodsDTO.getIngredients());
        assertThat(goodsEntity.getGTIN()).isEqualTo(goodsDTO.getGTIN());
        assertThat(goodsEntity.getGTIN()).isEqualTo(goodsDTO.getGTIN());
        assertThat(goodsEntity.getEAN_8()).isEqualTo(goodsDTO.getEAN_8());
        assertThat(goodsEntity.getEAN_13()).isEqualTo(goodsDTO.getEAN_13());
        assertThat(goodsEntity.getEAN_14()).isEqualTo(goodsDTO.getEAN_14());
        assertThat(goodsEntity.getEAN_128()).isEqualTo(goodsDTO.getEAN_128());
        assertThat(goodsEntity.getUPC()).isEqualTo(goodsDTO.getUPC());
        assertThat(goodsEntity.getUPC_A()).isEqualTo(goodsDTO.getUPC_A());
        assertThat(goodsEntity.getUPC_E()).isEqualTo(goodsDTO.getUPC_E());
        assertThat(goodsEntity.getBarcode()).isEqualTo(goodsDTO.getBarcode());
        assertThat(goodsEntity.getSKU()).isEqualTo(goodsDTO.getSKU());
        assertThat(goodsEntity.getUnitPrice()).isEqualTo(goodsDTO.getUnitPrice());
        assertThat(goodsEntity.getCreatedAt()).isEqualTo(goodsDTO.getCreatedAt());
    }

    private GoodsDTO provideDTO() {
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setId(1L);
        goodsDTO.setName("Product A");
        goodsDTO.setDescription("Goods description");
        goodsDTO.setMaker("Maker A");
        goodsDTO.setModel("ABCDE");
        goodsDTO.setNetWeight(BigDecimal.valueOf(2.256));
        goodsDTO.setGrossWeight(BigDecimal.valueOf(2.115));
        goodsDTO.setTechnicalSpecs("Technical Specifications");
        goodsDTO.setPatents(List.of("Pat A", "Pat B", "Pat C"));
        goodsDTO.setIngredients("Ingredients not applicable.");
        goodsDTO.setGTIN("123456");
        goodsDTO.setEAN_8("12345678");
        goodsDTO.setEAN_13("12345678");
        goodsDTO.setEAN_14("12345678");
        goodsDTO.setEAN_128("12345678");
        goodsDTO.setUPC("123456");
        goodsDTO.setUPC_A("123456");
        goodsDTO.setUPC_E("123456");
        goodsDTO.setBarcode("123456789");
        goodsDTO.setSKU("SKU1232456789");
        goodsDTO.setUnitPrice(BigDecimal.valueOf(19.99));
        goodsDTO.setCreatedAt(LocalDateTime.now());
        return goodsDTO;
    }

    private GoodsEntity provideEntity() {
        return new GoodsEntityBuilder()
                .withDefault()
                .build();
    }


}
