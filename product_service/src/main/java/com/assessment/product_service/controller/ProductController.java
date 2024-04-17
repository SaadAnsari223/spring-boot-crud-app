package com.assessment.product_service.controller;

import com.assessment.product_service.dto.GenericResponse;
import com.assessment.product_service.dto.ProductRequest;
import com.assessment.product_service.dto.ProductResponse;
import com.assessment.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<GenericResponse<List<ProductResponse>>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(GenericResponse.success(products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<ProductResponse>> getProduct(@PathVariable("id") Long id) {
        ProductResponse productResponse = productService.getProduct(id);
        return ResponseEntity.ok(GenericResponse.success(productResponse));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<ProductResponse>> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.createProduct(productRequest);
        return ResponseEntity.ok(GenericResponse.withMessageAndStatus("Product Created Successfully",true,productResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<ProductResponse>> updateProduct(@Valid @RequestBody ProductRequest productRequest, @PathVariable("id") Long id){
        ProductResponse productResponse = productService.updateProduct(productRequest,id);
        return ResponseEntity.ok(GenericResponse.withMessageAndStatus("updated Sucessfully",true,productResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<ProductResponse>> deleteProduct(@PathVariable("id") Long id)
    {
        ProductResponse productResponse = productService.deleteProduct(id);
        return ResponseEntity.ok(GenericResponse.withMessageAndStatus("Deleted Sucessfully",true,productResponse));
    }
}
