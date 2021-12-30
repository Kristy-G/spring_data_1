package com.example.spring_data_1.controller;

import com.example.spring_data_1.dto.ProductDto;
import com.example.spring_data_1.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartRestController {
    private final CartService cartService;

    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/all")
    public String getCart() {
        return cartService.getCart().toString();
    }

    @GetMapping("/add")
    public ProductDto addProductToCart(ProductDto productDto) {
        cartService.addProduct(productDto);
        return productDto;
    }

    @GetMapping("/delete")
    public ProductDto deleteProductFromCart(ProductDto productDto) {
        cartService.deleteProduct(productDto);
        return productDto;
    }
}
