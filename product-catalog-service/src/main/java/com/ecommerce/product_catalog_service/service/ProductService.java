package com.ecommerce.product_catalog_service.service;

import com.ecommerce.product_catalog_service.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts() {
        return Arrays.asList(
            new Product(1L, "iPhone 15 Pro", "Latest iPhone with advanced camera system", new BigDecimal("999.99"), "Electronics", "https://example.com/iphone15.jpg", 50),
            new Product(2L, "MacBook Air M2", "Lightweight laptop with M2 chip", new BigDecimal("1199.99"), "Electronics", "https://example.com/macbook-air.jpg", 30),
            new Product(3L, "Samsung Galaxy S24", "Android flagship smartphone", new BigDecimal("899.99"), "Electronics", "https://example.com/galaxy-s24.jpg", 40),
            new Product(4L, "Nike Air Max 270", "Comfortable running shoes", new BigDecimal("129.99"), "Footwear", "https://example.com/nike-airmax.jpg", 100),
            new Product(5L, "Adidas Ultraboost 22", "Premium running shoes", new BigDecimal("179.99"), "Footwear", "https://example.com/adidas-ultraboost.jpg", 75),
            new Product(6L, "Levi's 501 Jeans", "Classic straight fit jeans", new BigDecimal("59.99"), "Clothing", "https://example.com/levis-501.jpg", 200),
            new Product(7L, "Uniqlo T-Shirt", "Comfortable cotton t-shirt", new BigDecimal("19.99"), "Clothing", "https://example.com/uniqlo-tshirt.jpg", 300),
            new Product(8L, "Sony WH-1000XM5", "Noise-cancelling headphones", new BigDecimal("349.99"), "Electronics", "https://example.com/sony-headphones.jpg", 25),
            new Product(9L, "Apple Watch Series 9", "Smartwatch with health monitoring", new BigDecimal("399.99"), "Electronics", "https://example.com/apple-watch.jpg", 60),
            new Product(10L, "Dell XPS 13", "Premium ultrabook laptop", new BigDecimal("1099.99"), "Electronics", "https://example.com/dell-xps.jpg", 20)
        );
    }

    public Product getProductById(Long id) {
        return getProducts().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProductsByCategory(String category) {
        return getProducts().stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .toList();
    }
} 