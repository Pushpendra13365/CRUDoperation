package com.crudoperation.controller;

import com.crudoperation.entity.Product;
import com.crudoperation.service.ProductServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    //http://localhost:8080/api/product/save

    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        return productServices.saveProduct(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProduct(){
        return productServices.getAllProducts();
    }

    @GetMapping("/getById/{id}")
    public Product getProductById(@PathVariable int id){
        return productServices.getProductById(id);
    }

    @GetMapping("/getByName/{name}")
    public Product getProductByName(@PathVariable String name){
        return productServices.getProductByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productServices.deleteProduct(id);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productServices.updateProduct(product);
    }
}
