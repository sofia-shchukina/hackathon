package com.example.hackathon.requests;

import com.example.hackathon.customers.CustomerService;
import com.example.hackathon.stores.Coordinates;
import com.example.hackathon.util.GeoCodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingRequestService {
    @Autowired
    private final ShoppingRequestRepository shoppingRequestRepository;

    @Autowired
    private final CustomerService customerService;

    @Autowired
    public GeoCodingService geoCodingService;

    public ShoppingRequestService(ShoppingRequestRepository shoppingRequestRepository, CustomerService customerService, GeoCodingService geoCodingService) {
        this.shoppingRequestRepository = shoppingRequestRepository;
        this.customerService = customerService;
        this.geoCodingService = geoCodingService;
    }

    public ShoppingRequest addShoppingRequest(ShoppingRequest shoppingRequest) {
        return shoppingRequestRepository.save(shoppingRequest);
    }

    public List<ShoppingRequest> showAllCurrentShoppingRequest() {
        List<ShoppingRequest> allShoppingRequests = shoppingRequestRepository.findAll();

        return allShoppingRequests.stream()
                .filter(request -> request.getStatus().equals("open"))
                .collect(Collectors.toList());
    }


    public Optional<ShoppingRequest> getShoppingRequestById(String id) {
        return shoppingRequestRepository.findById(id);
    }

    public List<ShoppingRequest> getMyShoppingRequests(String myName) {
        List<ShoppingRequest> allShoppingRequests = shoppingRequestRepository.findAll();
        return allShoppingRequests.stream()
                .filter(request -> request.getNameOfTheRequester().equals(myName))
                .collect(Collectors.toList());
    }

    public List<ShoppingRequest> getNearbyRequests(String myAddress) {
        List<ShoppingRequest> allOpenShoppingRequests = showAllCurrentShoppingRequest();

        List<ShoppingRequest> nearbyShoppingRequests = new ArrayList<>();


        for (ShoppingRequest oneOpenShoppingRequest : allOpenShoppingRequests
        ) {
            Integer kilometersToRequest = calculateDistanceFromMe(myAddress, oneOpenShoppingRequest);
            if (kilometersToRequest <= 2) {
                System.out.println(kilometersToRequest);
                nearbyShoppingRequests.add(oneOpenShoppingRequest);
            }
        }
        return nearbyShoppingRequests;
    }

    private Integer calculateDistanceFromMe(String myAddress, ShoppingRequest oneOpenShoppingRequest) {

        double[] coordinates = geoCodingService.getCoordinates(myAddress);
        Coordinates myCoordinates = new Coordinates(coordinates[0], coordinates[1]);

        String formattedAddress = replaceSpacesWithPlus(oneOpenShoppingRequest.getAddress());
        double[] coordinatesOfTheRequest = geoCodingService.getCoordinates(formattedAddress);
        Coordinates requestCoordinates = new Coordinates(coordinatesOfTheRequest[0], coordinatesOfTheRequest[1]);


        double earthRadius = 6371; // Radius of the Earth in kilometers
        double lat1 = Math.toRadians(myCoordinates.getLatitude());
        double lon1 = Math.toRadians(myCoordinates.getLongitude());
        double lat2 = Math.toRadians(requestCoordinates.getLatitude());
        double lon2 = Math.toRadians(requestCoordinates.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (earthRadius * c);
    }

    public String replaceSpacesWithPlus(String input) {
        return input.replace(" ", "+");
    }
}



