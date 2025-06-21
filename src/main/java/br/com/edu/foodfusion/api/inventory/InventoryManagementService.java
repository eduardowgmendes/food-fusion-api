package br.com.edu.foodfusion.api.inventory;

import br.com.edu.foodfusion.shared.database.entity.inventory.goods.GoodsEntity;
import br.com.edu.foodfusion.shared.database.entity.inventory.goods.specification.GoodsEntitySpecification;
import br.com.edu.foodfusion.shared.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class InventoryManagementService {

    @Autowired
    private GoodsRepository goodsRepository;

    public List<GoodsEntity> findAllBy(Map<String, String> params) {
        return goodsRepository.findAll(GoodsEntitySpecification.withDynamicParams(params));
    }

    public List<GoodsEntity> findAll() {
        return goodsRepository.findAll();
    }

    public GoodsEntity findById(long goodsId) {
        return goodsRepository.findById(goodsId)
                .orElse(null);
    }

    public List<GoodsEntity> findByPriceInRangeBetween(double min, double max) {
        return goodsRepository.findByUnitPriceBetween(min, max)
                .orElse(null);
    }

    public List<GoodsEntity> findByName(String name) {
        return goodsRepository.findByNameLike(name)
                .orElse(null);
    }

    public List<GoodsEntity> findBySKU(String sku) {
        return goodsRepository.findBySKU(sku)
                .orElse(null);
    }

    public List<GoodsEntity> findByUPC(String upc) {
        return goodsRepository.findByUPC(upc)
                .orElse(null);
    }

    public List<GoodsEntity> findByUPCA(String upcA) {
        return goodsRepository.findByUPCA(upcA)
                .orElse(null);
    }

    public List<GoodsEntity> findByUPCE(String upcE) {
        return goodsRepository.findByUPCE(upcE)
                .orElse(null);
    }

    public List<GoodsEntity> findByGTIN(String gtin) {
        return goodsRepository.findByGTIN(gtin)
                .orElse(null);
    }

    public List<GoodsEntity> findByNCM(String ncm) {
        return goodsRepository.findByNCM(ncm)
                .orElse(null);
    }

    public List<GoodsEntity> findByBarcode(String rawBarcode) {
        return goodsRepository.findByBarcode(rawBarcode)
                .orElse(null);
    }

    public List<GoodsEntity> findByCategory(String category) {
        return goodsRepository.findByCategory(category)
                .orElse(null);
    }

    public GoodsEntity create(GoodsEntity goods) {
        if (goods != null) {
            goods.setCreatedAt(LocalDateTime.now());
            return goodsRepository.save(goods);
        }
        return null;
    }

    public GoodsEntity update(long goodsId, GoodsEntity updatedGoods) {
        GoodsEntity goodsFound = goodsRepository.findById(goodsId)
                .orElse(null);

        if (goodsFound != null) {
            goodsFound.setId(goodsId);
            goodsFound.setName(updatedGoods.getName());
            goodsFound.setDescription(updatedGoods.getDescription());
            goodsFound.setMaker(updatedGoods.getMaker());
            goodsFound.setModel(updatedGoods.getModel());
            goodsFound.setUnitPrice(updatedGoods.getUnitPrice());
            goodsFound.setGrossWeight(updatedGoods.getGrossWeight());
            goodsFound.setNetWeight(updatedGoods.getNetWeight());
            goodsFound.setEAN_8(updatedGoods.getEAN_8());
            goodsFound.setEAN_13(updatedGoods.getEAN_13());
            goodsFound.setEAN_14(updatedGoods.getEAN_14());
            goodsFound.setEAN_128(updatedGoods.getEAN_128());
            goodsFound.setSKU(updatedGoods.getSKU());
            goodsFound.setUPC(updatedGoods.getUPC());
            goodsFound.setUPC_A(updatedGoods.getUPC_A());
            goodsFound.setUPC_E(updatedGoods.getUPC_E());
            goodsFound.setGTIN(updatedGoods.getGTIN());
            goodsFound.setNCM(updatedGoods.getNCM());
            goodsFound.setBarcode(updatedGoods.getBarcode());
            goodsFound.setPatents(updatedGoods.getPatents());
            goodsFound.setCertifications(updatedGoods.getCertifications());
            goodsFound.setTechnicalSpecs(updatedGoods.getTechnicalSpecs());
            goodsFound.setIngredients(updatedGoods.getIngredients());
            goodsFound.setCategory(updatedGoods.getCategory());
            goodsFound.setUpdatedAt(LocalDateTime.now());
            return goodsRepository.save(goodsFound);
        }

        return null;
    }

    public void delete(long goodsId) {
        goodsRepository.deleteById(goodsId);
    }

}
