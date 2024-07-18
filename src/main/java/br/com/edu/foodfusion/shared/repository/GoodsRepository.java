package br.com.edu.foodfusion.shared.repository;

import br.com.edu.foodfusion.shared.database.entity.inventory.goods.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, Long> {

    Optional<List<GoodsEntity>> findByNameLike(String name);

    Optional<List<GoodsEntity>> findByEAN_8Like(String ean8);

    Optional<List<GoodsEntity>> findByEAN_13Like(String ean13);

    Optional<List<GoodsEntity>> findByEAN_14Like(String ean14);

    Optional<List<GoodsEntity>> findByEAN_128Like(String ean128);

    Optional<List<GoodsEntity>> findBySKULike(String sku);

    Optional<List<GoodsEntity>> findByUPCLike(String upc);

    Optional<List<GoodsEntity>> findByUPC_ALike(String upcA);

    Optional<List<GoodsEntity>> findByUPC_ELike(String upcE);

    Optional<List<GoodsEntity>> findByGTINLike(String gtin);

    Optional<List<GoodsEntity>> findByNCMLike(String ncm);

    Optional<List<GoodsEntity>> findBybBarcodeLike(String barcode);

    Optional<List<GoodsEntity>> findByCategory(String category);

    Optional<List<GoodsEntity>> findByUnitPriceBetween(double min, double max);

}
