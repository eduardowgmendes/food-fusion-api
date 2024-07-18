package br.com.edu.foodfusion.api.inventory;

import br.com.edu.foodfusion.shared.database.entity.inventory.goods.GoodsEntity;
import br.com.edu.foodfusion.shared.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InventoryManagementService {

    @Autowired
    private GoodsRepository goodsRepository;

    public List<GoodsEntity> findAllBy(Map<String, String> params) {
        return null;
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
        return goodsRepository.findBySKULike(sku)
                .orElse(null);
    }

    public List<GoodsEntity> findByUPC(String upc) {
        return goodsRepository.findByUPCLike(upc)
                .orElse(null);
    }

    public List<GoodsEntity> findByUPCA(String upcA) {
        return goodsRepository.findByUPC_ALike(upcA)
                .orElse(null);
    }

    public List<GoodsEntity> findByUPCE(String upcE) {
        return goodsRepository.findByUPC_ELike(upcE)
                .orElse(null);
    }

    public List<GoodsEntity> findByGTIN(String gtin) {
        return goodsRepository.findByGTINLike(gtin)
                .orElse(null);
    }

    public List<GoodsEntity> findByNCM(String ncm) {
        return goodsRepository.findByNCMLike(ncm)
                .orElse(null);
    }

    public List<GoodsEntity> findByBarcode(String rawBarcode) {
        return goodsRepository.findBybBarcodeLike(rawBarcode)
                .orElse(null);
    }

    public List<GoodsEntity> findByCategory(String category) {
        return goodsRepository.findByCategory(category)
                .orElse(null);
    }

}
