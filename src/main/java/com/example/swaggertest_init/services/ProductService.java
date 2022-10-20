package com.example.swaggertest_init.services;

import com.example.swaggertest_init.entites.Product;
import com.example.swaggertest_init.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(Product p){
        productRepository.save(p);
    }

    public Product getProduct(long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void updateProduct(long id, Product p){
        Product exist = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        exist.setTitle(p.getTitle());
        exist.setDescription(p.getDescription());
        exist.setPrice(p.getPrice());
        productRepository.save(exist);
    }

    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
