package com.example.hackathon.requests;

import com.example.hackathon.products.Product;

import java.util.List;

public class ShoppingRequest {

    String id;
    String nameOfTheRequester;

    List<Product> productsToBuy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameOfTheRequester() {
        return nameOfTheRequester;
    }

    public void setNameOfTheRequester(String nameOfTheRequester) {
        this.nameOfTheRequester = nameOfTheRequester;
    }

    public List<Product> getProductsToBuy() {
        return productsToBuy;
    }

    public void setProductsToBuy(List<Product> productsToBuy) {
        this.productsToBuy = productsToBuy;
    }
}
