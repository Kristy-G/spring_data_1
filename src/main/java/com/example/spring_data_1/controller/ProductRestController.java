package com.example.spring_data_1.controller;

import com.example.spring_data_1.converter.ProductConverter;
import com.example.spring_data_1.dto.ProductDto;
import com.example.spring_data_1.entity.Product;
import com.example.spring_data_1.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;


import static com.example.spring_data_1.converter.ProductConverter.productDtoToProduct;
import static com.example.spring_data_1.converter.ProductConverter.productToProductDto;

@RestController
@RequestMapping("/rest")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return productService.getAll().stream(ProductConverter::productToProductDto).map().collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductInfo(@PathVariable Long id) {
        ProductDto productDto = productToProductDto(productService.findById(id));
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ProductDto saveProduct(@RequestBody ProductDto productDto) {
        Product product = productDtoToProduct(productDto);
        productService.save(product);
        return productToProductDto(product);
    }
}
