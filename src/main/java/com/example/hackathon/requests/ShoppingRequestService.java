package com.example.hackathon.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingRequestService {
    @Autowired
    private final ShoppingRequestRepository shoppingRequestRepository;

    public ShoppingRequestService(ShoppingRequestRepository shoppingRequestRepository) {
        this.shoppingRequestRepository = shoppingRequestRepository;
    }
   public ShoppingRequest addShoppingRequest(ShoppingRequest shoppingRequest) {
        return shoppingRequestRepository.save(shoppingRequest);
    }

    public List<ShoppingRequest> showAllCurrentShoppingRequest() {
        List<ShoppingRequest> allShoppingRequests =  shoppingRequestRepository.findAll();

        return allShoppingRequests.stream()
                .filter(request -> request.getStatus().equals("open"))
                .collect(Collectors.toList());
    }


    public Optional<ShoppingRequest> getShoppingRequestById(String id) {
        return shoppingRequestRepository.findById(id);
    }

    public List<ShoppingRequest> getMyShoppingRequests(String myName) {
        List<ShoppingRequest> allShoppingRequests =  shoppingRequestRepository.findAll();
        return allShoppingRequests.stream()
                .filter(request -> request.getNameOfTheRequester().equals(myName))
                .collect(Collectors.toList());
    }
}
