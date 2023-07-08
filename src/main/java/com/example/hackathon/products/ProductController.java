package com.example.hackathon.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @GetMapping("/{id}/")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Optional<Product> productFoundById = productService.getProductById(id);
        return productFoundById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}