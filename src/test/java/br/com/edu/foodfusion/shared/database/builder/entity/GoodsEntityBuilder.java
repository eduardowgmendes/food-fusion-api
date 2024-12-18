package br.com.edu.foodfusion.shared.database.builder.entity;

import br.com.edu.foodfusion.shared.database.entity.inventory.goods.GoodsEntity;
import br.com.edu.foodfusion.shared.database.enums.GoodsCategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class GoodsEntityBuilder {

    private final GoodsEntity goodsEntity = new GoodsEntity();

    public static GoodsEntityBuilder anItem() {
        return new GoodsEntityBuilder();
    }

    public GoodsEntityBuilder withId(long goodsIds) {
        this.goodsEntity.setId(goodsIds);
        return this;
    }

    public GoodsEntityBuilder withName(String name) {
        this.goodsEntity.setName(name);
        return this;
    }

    public GoodsEntityBuilder withDescription(String description) {
        this.goodsEntity.setDescription(description);
        return this;
    }

    public GoodsEntityBuilder withModel(String model) {
        this.goodsEntity.setModel(model);
        return this;
    }

    public GoodsEntityBuilder withMaker(String maker) {
        this.goodsEntity.setMaker(maker);
        return this;
    }

    public GoodsEntityBuilder withGTINCode(String code) {
        this.goodsEntity.setGTIN(code);
        return this;
    }

    public GoodsEntityBuilder withBarcode(String barcode) {
        this.goodsEntity.setBarcode(barcode);
        return this;
    }

    public GoodsEntityBuilder withPatents(List<String> patents) {
        this.goodsEntity.setPatents(patents);
        return this;
    }

    public GoodsEntityBuilder withCertifications(List<String> certifications) {
        this.goodsEntity.setCertifications(certifications);
        return this;
    }

    public GoodsEntityBuilder withTechnicalSpecifications(String technicalSpecifications) {
        this.goodsEntity.setTechnicalSpecs(technicalSpecifications);
        return this;
    }

    public GoodsEntityBuilder withIngredients(String ingredients) {
        this.goodsEntity.setIngredients(ingredients);
        return this;
    }

    public GoodsEntityBuilder deleted() {
        this.goodsEntity.setDeletedAt(LocalDateTime.now());
        this.goodsEntity.setDeleted(true);
        return this;
    }

    public GoodsEntityBuilder withCategory(GoodsCategoryEnum category) {
        this.goodsEntity.setCategory(category);
        return this;
    }

    public GoodsEntityBuilder withSKUCode(String code) {
        this.goodsEntity.setSKU(code);
        return this;
    }

    public GoodsEntityBuilder withUPCCode(String code) {
        this.goodsEntity.setUPC(code);
        return this;
    }

    public GoodsEntityBuilder withUPCACode(String code) {
        this.goodsEntity.setUPC_A(code);
        return this;
    }

    public GoodsEntityBuilder withUPCECode(String code) {
        this.goodsEntity.setUPC_E(code);
        return this;
    }

    public GoodsEntityBuilder withEAN8Code(String code) {
        this.goodsEntity.setEAN_8(code);
        return this;
    }

    public GoodsEntityBuilder withEAN13Code(String code) {
        this.goodsEntity.setEAN_13(code);
        return this;
    }

    public GoodsEntityBuilder withEAN14Code(String code) {
        this.goodsEntity.setEAN_14(code);
        return this;
    }

    public GoodsEntityBuilder withEAN128Code(String code) {
        this.goodsEntity.setEAN_128(code);
        return this;
    }

    public GoodsEntityBuilder withUnitPrice(double unitPrice) {
        this.goodsEntity.setUnitPrice(BigDecimal.valueOf(unitPrice));
        return this;
    }

    public GoodsEntityBuilder withGrossWeight(double grossWeight) {
        this.goodsEntity.setGrossWeight(BigDecimal.valueOf(grossWeight));
        return this;
    }

    public GoodsEntityBuilder withNetWeight(double netWeight) {
        this.goodsEntity.setNetWeight(BigDecimal.valueOf(netWeight));
        return this;
    }

    public GoodsEntityBuilder withDefault() {
        this.goodsEntity.setId(1L);
        this.goodsEntity.setName("Goods Entity");
        this.goodsEntity.setDescription("Goods description for Entity");
        this.goodsEntity.setMaker("Maker Entity");
        this.goodsEntity.setModel("Entity ASR-G1");
        this.goodsEntity.setNetWeight(BigDecimal.valueOf(2.256));
        this.goodsEntity.setGrossWeight(BigDecimal.valueOf(2.115));
        this.goodsEntity.setTechnicalSpecs("Technical Specifications");
        this.goodsEntity.setPatents(List.of("Pat A", "Pat B", "Pat C"));
        this.goodsEntity.setIngredients("Ingredients not applicable.");
        this.goodsEntity.setGTIN("123456");
        this.goodsEntity.setEAN_8("12345678");
        this.goodsEntity.setEAN_13("12345678");
        this.goodsEntity.setEAN_14("12345678");
        this.goodsEntity.setEAN_128("12345678");
        this.goodsEntity.setUPC("123456");
        this.goodsEntity.setUPC_A("123456");
        this.goodsEntity.setUPC_E("123456");
        this.goodsEntity.setBarcode("123456789");
        this.goodsEntity.setNCM("123456789");
        this.goodsEntity.setCertifications(List.of("Certification A", "Certification B", "Certification C", "Certification E"));
        this.goodsEntity.setSKU("SKU1232456789");
        this.goodsEntity.setCategory(GoodsCategoryEnum.ACCESSORIES);
        this.goodsEntity.setUnitPrice(BigDecimal.valueOf(19.99));
        this.goodsEntity.setCreatedAt(LocalDateTime.now());
        return this;
    }

    public GoodsEntity build() {
        return this.goodsEntity;
    }

}
