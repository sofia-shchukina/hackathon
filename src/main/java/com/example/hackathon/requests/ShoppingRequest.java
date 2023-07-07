package com.example.hackathon.requests;

import com.example.hackathon.products.Product;

import java.util.List;

public class ShoppingRequest {


    public ShoppingRequest(String id, String nameOfTheRequester, List<Product> productsToBuy, String status) {
        this.id = id;
        this.nameOfTheRequester = nameOfTheRequester;
        this.productsToBuy = productsToBuy;
        this.status = status;
    }

    String id;
    String nameOfTheRequester;

    List<Product> productsToBuy;

    String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

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
