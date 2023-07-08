package com.example.hackathon.requests;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/request/")
public class ShoppingRequestController {

    private final ShoppingRequestService shoppingRequestService;

    public ShoppingRequestController(ShoppingRequestService shoppingRequestService) {
        this.shoppingRequestService = shoppingRequestService;
    }

   @PostMapping()
    public ResponseEntity<ShoppingRequest> addShoppingRequest(@RequestBody ShoppingRequest shoppingRequest){
        ShoppingRequest savedShoppingRequest =  shoppingRequestService.addShoppingRequest(shoppingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShoppingRequest);
    }

    @GetMapping()
    public ResponseEntity <List<ShoppingRequest>> showAllCurrentShoppingRequests(){
        List<ShoppingRequest> allCurrentShoppingRequest =  shoppingRequestService.showAllCurrentShoppingRequest();
        return ResponseEntity.status(HttpStatus.CREATED).body(allCurrentShoppingRequest);
    }

   @GetMapping("/{id}/")
   public ResponseEntity<ShoppingRequest> getShoppingRequestById(@PathVariable String id) {
       Optional<ShoppingRequest> shoppingRequestFoundById = shoppingRequestService.getShoppingRequestById(id);
       return shoppingRequestFoundById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }
}
