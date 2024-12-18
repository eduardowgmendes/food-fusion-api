package br.com.edu.foodfusion.api.inventory;

import br.com.edu.foodfusion.shared.database.entity.inventory.goods.GoodsEntity;
import br.com.edu.foodfusion.shared.dto.inventory.GoodsDTO;
import br.com.edu.foodfusion.shared.request.CreateGoodsRequest;
import br.com.edu.foodfusion.shared.request.UpdateGoodsRequest;
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

    @GetMapping("/find/by")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findBy(@RequestParam Map<String, String> details) {
        List<GoodsEntity> goodsFound = inventoryManagementService.findAllBy(details);

        if (goodsFound.isEmpty())
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

        if (goods.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_sku")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findBySKU(@RequestParam(name = "code") String code) {
        List<GoodsEntity> goods = inventoryManagementService.findBySKU(code);

        if (goods.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_upc")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByUPC(@RequestParam(name = "code") String code) {
        List<GoodsEntity> goods = inventoryManagementService.findByUPC(code);

        if (goods.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_upca")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByUPCA(@RequestParam(name = "code") String code) {
        List<GoodsEntity> goods = inventoryManagementService.findByUPCA(code);

        if (goods.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_upce")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByUPCE(@RequestParam(name = "code") String code) {
        List<GoodsEntity> goods = inventoryManagementService.findByUPCE(code);

        if (goods.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_gtin")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByGTIN(@RequestParam(name = "code") String gtin) {
        List<GoodsEntity> goods = inventoryManagementService.findByGTIN(gtin);

        if (goods.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_ncm")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByNCM(@RequestParam(name = "code") String ncm) {
        List<GoodsEntity> goods = inventoryManagementService.findByNCM(ncm);

        if (goods.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_barcode")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByBarcode(@RequestParam(name = "code") String rawBarcode) {
        List<GoodsEntity> goods = inventoryManagementService.findByBarcode(rawBarcode);

        if (goods.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @GetMapping("/find/by_category")
    public ResponseEntity<DefaultResponse<List<GoodsDTO>>> findByCategory(@RequestParam(name = "category") String category) {
        List<GoodsEntity> goods = inventoryManagementService.findByCategory(category);

        if (goods.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters.", null));

        return ResponseEntity.ok(DefaultResponse.create(true, "Here is the goods found.", goods.stream()
                .map(GoodsEntity::toDTO)
                .collect(Collectors.toList())));
    }

    @PostMapping("/update")
    public ResponseEntity<DefaultResponse<GoodsDTO>> update(@RequestBody UpdateGoodsRequest updateGoodsRequest) {
        long goodsId = updateGoodsRequest.getGoodsId();

        GoodsEntity updatedGoods = inventoryManagementService.update(goodsId, GoodsDTO.toEntity(updateGoodsRequest.getGoods()));

        if (updatedGoods == null)
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(DefaultResponse.create(false, "Nothing found with given parameters", null));

        return ResponseEntity
                .ok(DefaultResponse.create(true, "Goods updated with success.", GoodsEntity.toDTO(updatedGoods)));
    }

    @PostMapping("/create")
    public ResponseEntity<DefaultResponse<GoodsDTO>> create(@RequestBody CreateGoodsRequest createGoodsRequest) {
        GoodsEntity goodsCreated = inventoryManagementService.create(GoodsDTO.toEntity(createGoodsRequest.getNewGoods()));

        if (goodsCreated != null)
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(DefaultResponse.create(true, "Goods added to inventory.", GoodsEntity.toDTO(goodsCreated)));

        return ResponseEntity
                .badRequest()
                .body(DefaultResponse.create(false, "Failed to create a new inventory entry.", null));
    }

    @DeleteMapping("/delete/{goodsId}")
    public ResponseEntity<DefaultResponse<Long>> deleteById(@PathVariable(name = "goodsId") long goodsId) {
        GoodsEntity goodsFound = inventoryManagementService.findById(goodsId);

        if (goodsFound != null) {
            inventoryManagementService.delete(goodsFound.getId());
            return ResponseEntity
                    .ok(DefaultResponse.create(true, String.format("Goods at inventory with id %d deleted with success", goodsId), goodsId));
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(DefaultResponse.create(false, "Nothing found with given parameters", null));
    }

}
