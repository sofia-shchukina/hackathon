package com.example.hackathon.products;

import com.example.hackathon.requests.ShoppingRequest;
import com.example.hackathon.requests.ShoppingRequestRepository;
import com.example.hackathon.users.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
