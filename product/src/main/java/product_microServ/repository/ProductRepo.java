package product_microServ.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import product_microServ.model.Product;

public interface ProductRepo extends MongoRepository<Product, String> {
}
