package com.crudoperation.service;

import com.crudoperation.entityProduct.Product;
import com.crudoperation.exception.PartiCularProductNotFoundException;
import com.crudoperation.exception.ProductNotFoundException;
import com.crudoperation.repositoryProduct.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServices {

    private final ProductRepository productRepository;

    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //post method
    public Product saveProduct(Product product){
        if (product == null || product.getName() == null || product.getName().isEmpty()){
            log.error("Product is null cannot save");
            return null;
        }
        return productRepository.save(product);
    }

    // save list of product
    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }
    // get all product
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // get product by id
    public Product getProductById(int id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("product with id " + id + " not found"));
    }

    public Product getProductByName(String name){

        return productRepository.getProductByName(name);
    }

    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Product is deleted";
    }
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElseThrow(()-> new PartiCularProductNotFoundException("Product not found " + product.getId()));
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }
}
