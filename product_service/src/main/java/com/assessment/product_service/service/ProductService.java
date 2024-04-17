package com.assessment.product_service.service;

import com.assessment.product_service.dto.ProductRequest;
import com.assessment.product_service.dto.ProductResponse;
import com.assessment.product_service.exception.ResourceNotFoundException;
import com.assessment.product_service.model.Product;
import com.assessment.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private static final Logger logger = LogManager.getLogger(ProductService.class);

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        logger.info("Created new product:{}", productRequest);
        return mapToProductResponse(product);

    }

    public ProductResponse updateProduct(ProductRequest productRequest, Long id)
    {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
        logger.info("Product updated successfully with id: {}", id);
        return mapToProductResponse(product);
    }
    public ProductResponse deleteProduct(Long id)
    {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        productRepository.deleteById(id);
        logger.info("Product deleted successfully with id: {}", id);
        return mapToProductResponse(product);
    }

    public List<ProductResponse> getAllProducts()
    {
        logger.info("Retrieving all products");
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    public ProductResponse getProduct(Long id)
    {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        logger.info("Retrieved product with id: {}", id);
        return mapToProductResponse(product);
    }

    public ProductResponse mapToProductResponse(Product product)
    {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }

}
