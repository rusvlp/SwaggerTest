package com.example.swaggertest_init.controllers;

import com.example.swaggertest_init.entites.Product;
import com.example.swaggertest_init.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id){
        return productService.getProduct(id);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product p){
        productService.createProduct(p);
    }

    @PutMapping("/edit/{id}")
    public void editProduct(@PathVariable long id, @RequestBody Product p){
        productService.updateProduct(id, p);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }
}
