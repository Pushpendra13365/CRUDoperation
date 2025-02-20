package com.crudoperation.repository;

import com.crudoperation.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getProductByName(String name);
}
