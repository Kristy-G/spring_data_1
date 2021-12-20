package com.example.spring_data_1.repository;

import com.example.spring_data_1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void saveProduct(Product product);

    void deleteProductById(Long id);
}
