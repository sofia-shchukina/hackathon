package com.example.hackathon.stores;

import com.example.hackathon.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> showAllStores() {
        return storeRepository.findAll();
    }

    public void saveAllStores(List<Store> allStores) {

        storeRepository.saveAll(allStores);
    }

}
