package com.example.hackathon.stores;

import com.example.hackathon.products.Product;
import com.example.hackathon.util.GeoCodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository, GeoCodingService geoCodingService) {
        this.storeRepository = storeRepository;
        this.geoCodingService = geoCodingService;
    }

    @Autowired
    public GeoCodingService geoCodingService;

    public List<Store> showAllStores() {
        return storeRepository.findAll();
    }

    public void saveAllStores(List<Store> allStores) {

        storeRepository.saveAll(allStores);
    }

    public Store showNearestStore(String myAddress) {
        double[] coordinates = geoCodingService.getCoordinates(myAddress);
        Coordinates myCoordinates = new Coordinates(coordinates[0], coordinates[1]);

        List<Store> allStores = showAllStores();
        List<Coordinates> storeCoordinates = new ArrayList<>();

        for (Store store : allStores
        ) {
            String address = store.getAddress().toString();
            double[] storeCoordinate = geoCodingService.getCoordinates(address);
            storeCoordinates.add(new Coordinates(storeCoordinate[0], storeCoordinate[1]));
        }
        double minDistance = Double.MAX_VALUE;
        Store nearestStore = null;

        for (int i = 0; i < allStores.size(); i++) {
            Coordinates storeCoordinate = storeCoordinates.get(i);
            double distance = calculateDistance(myCoordinates, storeCoordinate);
            System.out.println(distance);
            if (distance < minDistance) {
                minDistance = distance;
                nearestStore = allStores.get(i);
            }
        }

        return nearestStore;
    }


    private double calculateDistance(Coordinates coordinate1, Coordinates coordinate2) {
        double earthRadius = 6371; // Radius of the Earth in kilometers
        double lat1 = Math.toRadians(coordinate1.getLatitude());
        double lon1 = Math.toRadians(coordinate1.getLongitude());
        double lat2 = Math.toRadians(coordinate2.getLatitude());
        double lon2 = Math.toRadians(coordinate2.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }

}
