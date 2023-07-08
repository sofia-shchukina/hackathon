package com.example.hackathon.products;

import com.example.hackathon.requests.ShoppingRequest;
import com.example.hackathon.requests.ShoppingRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/product/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> showAllProducts() {
        List<Product> allCurrentShoppingRequest = productService.showAllArticles();
        return ResponseEntity.status(HttpStatus.CREATED).body(allCurrentShoppingRequest);
    }

}