package com.example.hackathon.requests;


import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ShoppingRequestRepository {

    List<ShoppingRequest> shoppingRequests;

    public ShoppingRequestRepository() {
        this.shoppingRequests = new ArrayList<>();
    }

    public ShoppingRequest addShoppingRequest(@RequestBody ShoppingRequest shoppingRequest) {
         shoppingRequests.add(shoppingRequest);
         return shoppingRequest;
    }

    public List<ShoppingRequest> getAllShoppingRequests() {
        return shoppingRequests;
    }

    public boolean deleteShoppingRequestById(ShoppingRequest shoppingRequest) {
        return shoppingRequests.remove(shoppingRequest);
    }

    public ShoppingRequest getShoppingRequestById(String id) {
        for (ShoppingRequest shoppingRequest : shoppingRequests) {
            if (shoppingRequest.getId().equals(id)) {
                return shoppingRequest;
            }
        }
        return null;
    }
}
