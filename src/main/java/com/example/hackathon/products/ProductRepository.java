package com.example.hackathon.products;

import com.example.hackathon.requests.ShoppingRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository {

    List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }
    public List<Product> showAllArticles() {
        return products;
    }


}
