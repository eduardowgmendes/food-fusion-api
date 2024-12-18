package br.com.edu.foodfusion.shared.database.entity.inventory.goods.specification;

import br.com.edu.foodfusion.shared.database.entity.inventory.goods.GoodsEntity;
import br.com.edu.foodfusion.shared.database.enums.GoodsCategoryEnum;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.Map;

public class GoodsEntitySpecification {

    public static Specification<GoodsEntity> withDynamicParams(Map<String, String> params) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            // TODO - Estudar melhor como implementar essa Specification da melhor forma mais flexível possível
            if (params.containsKey("name"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name"), params.get("name")));

            if (params.containsKey("description"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("description"), params.get("description")));

            if (params.containsKey("maker"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("maker"), params.get("maker")));

            if (params.containsKey("model"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("model"), params.get("model")));

            if (params.containsKey("unitPrice"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("unitPrice"), new BigDecimal(params.get("unitPrice"))));

            if (params.containsKey("grossWeight"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("grossWeight"), new BigDecimal(params.get("grossWeight"))));

            if (params.containsKey("netWeight"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("netWeight"), new BigDecimal(params.get("netWeight"))));

            if (params.containsKey("EAN_8"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("EAN_8"), params.get("EAN_8")));

            if (params.containsKey("EAN_13"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("EAN_13"), params.get("EAN_13")));

            if (params.containsKey("EAN_14"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("EAN_14"), params.get("EAN_14")));

            if (params.containsKey("EAN_128"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("EAN_128"), params.get("EAN_128")));

            if (params.containsKey("SKU"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("SKU"), params.get("SKU")));

            if (params.containsKey("UPC"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("UPC"), params.get("UPC")));

            if (params.containsKey("UPC_A"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("UPC_A"), params.get("UPC_A")));

            if (params.containsKey("UPC_E"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("UPC_E"), params.get("UPC_E")));

            if (params.containsKey("GTIN"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("GTIN"), params.get("GTIN")));

            if (params.containsKey("NCM"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("NCM"), params.get("NCM")));

            if (params.containsKey("barcode"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("barcode"), params.get("barcode")));

            if (params.containsKey("patents")) {
                Join<GoodsEntity, String> patentsJoin = root.join("patents");
                predicate = criteriaBuilder.and(predicate, patentsJoin.in(params.get("patents").split(",")));
            }
            if (params.containsKey("certifications")) {
                Join<GoodsEntity, String> certificationsJoin = root.join("certifications");
                predicate = criteriaBuilder.and(predicate, certificationsJoin.in(params.get("certifications").split(",")));
            }
            if (params.containsKey("technicalSpecs"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("technicalSpecs"), params.get("technicalSpecs")));

            if (params.containsKey("ingredients"))
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("ingredients"), params.get("ingredients")));

            if (params.containsKey("category")) {
                GoodsCategoryEnum category = GoodsCategoryEnum.valueOf(params.get("category"));
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("category"), category));
            }

            return predicate;
        };
    }

}
