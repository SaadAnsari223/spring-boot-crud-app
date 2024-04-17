package com.assessment.product_service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotEmpty
    @Size(min=3, message = "invalid name, should be minimum 3 Char")
    private String name;

    @NotEmpty
    @Size(min=5, message = "invalid description, should be minimum 5 Char")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.6", message = "Price must be greater than 0.5")
    private BigDecimal price;
}
