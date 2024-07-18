package br.com.edu.foodfusion.shared.database.entity.inventory.goods;

import br.com.edu.foodfusion.shared.database.converter.GoodsCategoryConverter;
import br.com.edu.foodfusion.shared.database.enums.GoodsCategoryEnum;
import br.com.edu.foodfusion.shared.dto.inventory.GoodsDTO;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "goods")
public class GoodsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "maker")
    private String maker;

    @Column(name = "model")
    private String model;

    @Column(name = "unit_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal unitPrice;

    /**
     * Indicates the weight of the product WITH packaging.
     */
    @Column(name = "gross_weight", precision = 10, scale = 2)
    private BigDecimal grossWeight;

    /**
     * Indicates the weight of the product WITHOUT packaging.
     */
    @Column(name = "net_weight", precision = 10, scale = 2)
    private BigDecimal netWeight;

    @Column(name = "ean_8_code", length = 8)
    private String EAN_8;

    @Column(name = "ean_13_code", length = 13)
    private String EAN_13;

    @Column(name = "ean_14_code", length = 14)
    private String EAN_14;

    @Column(name = "ean_128_code", length = 80)
    private String EAN_128;

    @Column(name = "sku_code")
    private String SKU;

    @Column(name = "upc_code", length = 12)
    private String UPC;

    @Column(name = "upc_a_code", length = 12)
    private String UPC_A;

    @Column(name = "upc_e_code", length = 6)
    private String UPC_E;

    @Column(name = "gtin_code")
    private String GTIN;

    @Column(name = "ncm_code")
    private String NCM;

    @Column(name = "barcode", columnDefinition = "TEXT")
    private String barcode;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "patents", joinColumns = @JoinColumn(name = "goods_id"))
    @Column(name = "patents")
    private List<String> patents;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "certifications", joinColumns = @JoinColumn(name = "goods_id"))
    @Column(name = "certifications")
    private List<String> certifications;

    @Column(name = "technical_specs")
    private String technicalSpecs;

    @Column(name = "ingredients")
    private String ingredients;

    @Enumerated(EnumType.STRING)
    @Convert(converter = GoodsCategoryConverter.class)
    private GoodsCategoryEnum category;

    public static GoodsDTO toDTO(GoodsEntity goods) {
        return new ModelMapper()
                .map(goods, GoodsDTO.class);
    }
}
