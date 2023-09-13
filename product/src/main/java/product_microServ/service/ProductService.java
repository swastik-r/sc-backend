package product_microServ.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import product_microServ.dto.ProductResponse;
import product_microServ.dto.ProductRequest;
import product_microServ.dto.UpdateRequest;
import product_microServ.model.Product;
import product_microServ.repository.ProductRepo;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepo productRepo;

    // Add a Product
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .brandName(productRequest.getBrandName())
                .productName(productRequest.getProductName())
                .desc(productRequest.getDesc())
                .price(productRequest.getPrice())
                .build();
        productRepo.save(product);

        log.info("Product {} {} with ID: '{}' has been SAVED.",
                product.getBrandName(),
                product.getProductName(),
                product.getId());
    }

    // Update Product Details
    public void updateProduct(UpdateRequest updateRequest) {
        String id = updateRequest.getId();
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID:" + id + " NOT FOUND."));

        updateIfNotNull(updateRequest.getBrandName(), product::setBrandName);
        updateIfNotNull(updateRequest.getProductName(), product::setProductName);
        updateIfNotNull(updateRequest.getDesc(), product::setDesc);
        updateIfNotNull(updateRequest.getPrice(), product::setPrice);

        productRepo.save(product);
        log.info("Product {} {} with ID: '{}' has been UPDATED.",
                product.getBrandName(),
                product.getProductName(),
                product.getId());
    }
    private <T> void updateIfNotNull(T value, Consumer<T> updater) {
        Optional.ofNullable(value).ifPresent(updater);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> productList = productRepo.findAll();
        return productList.stream().map(this::mapToProductResponse).toList();
    }
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .brandName(product.getBrandName())
                .productName(product.getProductName())
                .desc(product.getDesc())
                .price(product.getPrice())
                .build();
    }
}
