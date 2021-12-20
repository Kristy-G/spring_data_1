package com.example.spring_data_1.controller;

import com.example.spring_data_1.entity.Product;
import com.example.spring_data_1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/products")
    public void saveProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProduct(Long id) {
        productService.deleteById(id);
    }
}
