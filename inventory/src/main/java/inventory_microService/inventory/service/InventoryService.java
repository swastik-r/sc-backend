package inventory_microService.inventory.service;

import inventory_microService.inventory.model.Inventory;
import inventory_microService.inventory.repository.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepo inventoryRepo;
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        return inventoryRepo.findBySkuCode(skuCode).isPresent();
    }

    public List<Inventory> getInventory() {
        return inventoryRepo.findAll();
    }
}
