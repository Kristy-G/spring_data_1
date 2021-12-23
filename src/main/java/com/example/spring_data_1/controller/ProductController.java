package com.example.spring_data_1.controller;

import com.example.spring_data_1.entity.Product;
import com.example.spring_data_1.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getAllStudents(Model model) {
        List<Product> products = (List<Product>) productService.getAll();
        model.addAttribute("products", products);
        return "product_list";
    }

    @PostMapping("/delete/{id}")
    public String saveProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }
}
