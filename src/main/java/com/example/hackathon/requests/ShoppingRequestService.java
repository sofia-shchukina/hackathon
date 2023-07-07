package com.example.hackathon.requests;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingRequestService {

    private final ShoppingRequestRepository shoppingRequestRepository;

    public ShoppingRequestService(ShoppingRequestRepository shoppingRequestRepository) {
        this.shoppingRequestRepository = shoppingRequestRepository;
    }
    public ShoppingRequest addShoppingRequest(ShoppingRequest shoppingRequest) {
        return shoppingRequestRepository.addShoppingRequest(shoppingRequest);
    }

    public List<ShoppingRequest> showAllCurrentShoppingRequest() {
        List<ShoppingRequest> allShoppingRequests =  shoppingRequestRepository.getAllShoppingRequests();

        return allShoppingRequests.stream()
                .filter(request -> request.getStatus().equals("open"))
                .collect(Collectors.toList());
    }

    public boolean deleteShoppingRequestById(String id) {
        ShoppingRequest existingRequest = shoppingRequestRepository.getShoppingRequestById(id);
        if (existingRequest != null) {
            return shoppingRequestRepository.deleteShoppingRequestById(existingRequest);
        }
        return false;
    }
}
