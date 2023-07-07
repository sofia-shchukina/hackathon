package com.example.hackathon.requests;

import org.springframework.stereotype.Service;

@Service
public class ShoppingRequestService {

    private final ShoppingRequestRepository shoppingRequestRepository;

    public ShoppingRequestService(ShoppingRequestRepository shoppingRequestRepository) {
        this.shoppingRequestRepository = shoppingRequestRepository;
    }
    public ShoppingRequest addShoppingRequest(ShoppingRequest shoppingRequest) {
        return shoppingRequestRepository.addShoppingRequest(shoppingRequest);
    }
}
