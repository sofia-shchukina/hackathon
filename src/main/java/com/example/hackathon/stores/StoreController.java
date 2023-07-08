package com.example.hackathon.stores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/store/")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping()
    public ResponseEntity<List<Store>> showAllStores() {
        List<Store> allStores = storeService.showAllStores();
        return ResponseEntity.status(HttpStatus.OK).body(allStores);
    }

 /*   GetMapping("/near/")
    public ResponseEntity<List<Store>> showOnlyNearbyStores() {
        List<Store> nearbyStores = storeService.showAllArticles();
        return ResponseEntity.status(HttpStatus.OK).body(allCurrentShoppingRequest);
    } */

}