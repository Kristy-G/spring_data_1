package com.example.spring_data_1.cart;

import com.example.spring_data_1.dto.ProductDto;
import com.example.spring_data_1.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private final List<ProductDto> productList;

    public Cart() {
        productList = new ArrayList<>();
    }

    public void addProduct(ProductDto productDto) {
        productList.add(productDto);
    }

    public void deleteProduct(ProductDto productDto) {
        productList.remove(productDto);
    }
}
