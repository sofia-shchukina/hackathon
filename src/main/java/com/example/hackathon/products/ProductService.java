package com.example.hackathon.products;

import com.example.hackathon.requests.ShoppingRequest;
import com.example.hackathon.requests.ShoppingRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> showAllArticles() {
        return productRepository.showAllArticles();
    }
}
