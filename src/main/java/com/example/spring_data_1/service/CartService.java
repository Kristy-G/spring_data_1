package com.example.spring_data_1.service;

import com.example.spring_data_1.cart.Cart;
import com.example.spring_data_1.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final Cart cart;

    public CartService(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void addProduct(ProductDto productDto) {
        cart.addProduct(productDto);
    }

    public void deleteProduct(ProductDto productDto) {
        cart.deleteProduct(productDto);
    }

}
