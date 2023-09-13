package inventory_microService.inventory.controller;
import inventory_microService.inventory.model.Inventory;
import inventory_microService.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code") String skuCode) {
        return inventoryService.isInStock(skuCode);
    }

    @GetMapping("/inventoryList")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Inventory>> getInventory() {
        List<Inventory> inventoryList = inventoryService.getInventory();
        return ResponseEntity.ok(inventoryList);
    }
}
