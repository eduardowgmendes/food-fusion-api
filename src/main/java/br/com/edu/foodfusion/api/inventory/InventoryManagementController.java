package br.com.edu.foodfusion.api.inventory;

import br.com.edu.foodfusion.shared.database.entity.inventory.goods.GoodsEntity;
import br.com.edu.foodfusion.shared.database.enums.GoodsCategoryEnum;
import br.com.edu.foodfusion.shared.dto.inventory.GoodsDTO;
import br.com.edu.foodfusion.shared.response.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryManagementController {

    @Autowired
    private InventoryManagementService inventoryManagementService;

    @GetMapping
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findBy(@RequestParam Map<String, String> details) {
        List<GoodsEntity> goodsFound = inventoryManagementService.findAllBy(details);

        if (goodsFound == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.fail("Nothing found with given parameters."));

        return ResponseEntity.ok(DefaultResponse.success("Here is the goods found.", goodsFound.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/all")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findAll() {
        List<GoodsEntity> goodsFound = inventoryManagementService.findAll();

        if (goodsFound.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goodsFound.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/{goodsId}")
    public ResponseEntity<DefaultResponse<GoodsDTO>> findById(@PathVariable(name = "goodsId") long goodsId) {
        GoodsEntity good = inventoryManagementService.findById(goodsId);

        if (good == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the good found.", GoodsEntity.toDTO(good)));
    }

    @GetMapping("/find/by_name")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByName(@RequestParam(name = "name") String name) {
        List<GoodsEntity> goods = inventoryManagementService.findByName(name);

        if (goods == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_sku")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findBySKU(@RequestParam(name = "sku") String code) {
        List<GoodsEntity> goods = inventoryManagementService.findBySKU(code);

        if (goods == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_upc")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByUPC(@RequestParam(name = "upc") String code) {
        List<GoodsEntity> goods = inventoryManagementService.findByUPC(code);

        if (goods == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_upca")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByUPCA(@RequestParam(name = "upca") String code) {
        List<GoodsEntity> goods = inventoryManagementService.findByUPCA(code);

        if (goods == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_upce")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByUPCE(@RequestParam(name = "upce") String code) {
        List<GoodsEntity> goods = inventoryManagementService.findByUPCE(code);

        if (goods == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_gtin")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByGTIN(@RequestParam(name = "gtin") String gtin) {
        List<GoodsEntity> goods = inventoryManagementService.findByGTIN(gtin);

        if (goods == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_ncm")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByNCM(@RequestParam(name = "ncm") String ncm) {
        List<GoodsEntity> goods = inventoryManagementService.findByNCM(ncm);

        if (goods == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_barcode")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByBarcode(@RequestParam(name = "rawBarcode") String rawBarcode) {
        List<GoodsEntity> goods = inventoryManagementService.findByBarcode(rawBarcode);

        if (goods == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_category")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByCategory(@RequestParam(name = "category") String category) {
        GoodsCategoryEnum goodCategory = GoodsCategoryEnum.valueOf(category);

        List<GoodsEntity> goods = inventoryManagementService.findByCategory(goodCategory.name());

        if (goods == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }
}
