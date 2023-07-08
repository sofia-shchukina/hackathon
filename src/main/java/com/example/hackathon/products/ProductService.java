package com.example.hackathon.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> showAllArticles() {
        return productRepository.findAll();
    }

    public void saveAllProducts(List<Product> allProducts) {

        productRepository.saveAll(allProducts);
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }
}
