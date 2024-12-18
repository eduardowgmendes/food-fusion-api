package br.com.edu.foodfusion.shared.repository;

import br.com.edu.foodfusion.shared.database.entity.inventory.goods.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, Long>, JpaSpecificationExecutor<GoodsEntity> {

    @Query("select g from GoodsEntity g where g.name like concat('%', :name, '%')")
    Optional<List<GoodsEntity>> findByNameLike(@Param("name") String name);

    @Query("select g from GoodsEntity g where g.EAN_8 = :ean8Code")
    Optional<List<GoodsEntity>> findByEAN_8(@Param("ean8Code") String ean8Code);

    @Query("select g from GoodsEntity g where g.EAN_13 = :ean13Code")
    Optional<List<GoodsEntity>> findByEAN_13(@Param("ean13Code") String ean13Code);

    @Query("select g from GoodsEntity g where g.EAN_14 = :ean14Code")
    Optional<List<GoodsEntity>> findByEAN_14(@Param("ean14Code") String ean14Code);

    @Query("select g from GoodsEntity g where g.EAN_128 = :ean128Code")
    Optional<List<GoodsEntity>> findByEAN_128(@Param("ean128Code") String ean128Code);

    @Query("select g from GoodsEntity g where g.SKU = :skuCode")
    Optional<List<GoodsEntity>> findBySKU(@Param("skuCode") String skuCode);

    @Query("select g from GoodsEntity g where g.UPC = :upcCode")
    Optional<List<GoodsEntity>> findByUPC(@Param("upcCode") String upcCode);

    @Query("select g from GoodsEntity g where g.UPC_A = :upcACode")
    Optional<List<GoodsEntity>> findByUPCA(@Param("upcACode") String upcACode);

    @Query("select g from GoodsEntity g where g.UPC_E = :upcECode")
    Optional<List<GoodsEntity>> findByUPCE(@Param("upcECode") String upcECode);

    @Query("select g from GoodsEntity g where g.GTIN = :gtinCode")
    Optional<List<GoodsEntity>> findByGTIN(@Param("gtinCode") String gtinCode);

    @Query("select g from GoodsEntity g where g.NCM = :ncmCode")
    Optional<List<GoodsEntity>> findByNCM(@Param("ncmCode") String ncmCode);

    @Query("select g from GoodsEntity g where g.barcode = :barcode")
    Optional<List<GoodsEntity>> findByBarcode(String barcode);

    @Query("select g from GoodsEntity g where lower(g.category) like lower(concat('%', :category, '%' ))")
    Optional<List<GoodsEntity>> findByCategory(String category);

    @Query("select g from GoodsEntity g where g.unitPrice between :min and :max")
    Optional<List<GoodsEntity>> findByUnitPriceBetween(@Param("min") double min, @Param("max") double max);

}
