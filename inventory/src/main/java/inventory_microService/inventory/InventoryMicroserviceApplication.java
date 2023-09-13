package inventory_microService.inventory;
import inventory_microService.inventory.model.Inventory;
import inventory_microService.inventory.repository.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class InventoryMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventoryMicroserviceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryRepo inventoryRepo) {
		return args -> {
			inventoryRepo.deleteAll();
			Inventory inventory0 = new Inventory();
			inventory0.setSkuCode("iPhone_16");
			inventory0.setQuantity(100);
			inventoryRepo.save(inventory0);
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iPhone_16_Red");
			inventory1.setQuantity(1);
			inventoryRepo.save(inventory1);
		};
	}
}
