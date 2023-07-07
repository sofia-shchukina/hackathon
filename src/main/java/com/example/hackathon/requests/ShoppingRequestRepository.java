package com.example.hackathon.requests;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ShoppingRequestRepository {

    List<ShoppingRequest> shoppingRequests;

    public ShoppingRequestRepository() {
        this.shoppingRequests = new ArrayList<>();
    }


    public ShoppingRequest addShoppingRequest(ShoppingRequest shoppingRequest) {
         shoppingRequests.add(shoppingRequest);
         return shoppingRequest;
    }
}
