package com.crudoperation.repositoryProduct;

import com.crudoperation.entityProduct.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getProductByName(String name);
}
