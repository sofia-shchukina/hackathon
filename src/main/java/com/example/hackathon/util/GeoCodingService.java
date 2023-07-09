package com.example.hackathon.util;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.util.UriComponentsBuilder;


@Service
public class GeoCodingService {
    private static final String GEOCODING_API_URL = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String API_KEY = "AIzaSyB9xb4Yu3_8mLvV0nhphW_bVE_xCVEROFY";


    public double[] getCoordinates(String address) {
            String url = UriComponentsBuilder.fromHttpUrl(GEOCODING_API_URL)
                    .queryParam("address", address)
                    .queryParam("key", API_KEY)
                    .toUriString();


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);


        if (response.getStatusCode().is2xxSuccessful()) {
            JSONObject jsonObject = new JSONObject(response.getBody());

            if (jsonObject.getString("status").equals("OK")) {
                JSONObject location = jsonObject.getJSONArray("results")
                        .getJSONObject(0)
                        .getJSONObject("geometry")
                        .getJSONObject("location");

                double latitude = location.getDouble("lat");
                double longitude = location.getDouble("lng");

                return new double[]{latitude, longitude};
            } else {
                throw new RuntimeException("Unable to geocode the address.");
            }
        } else {
            throw new RuntimeException("Error retrieving geocoding data. Status code: " + response.getStatusCodeValue());
        }
    }

}
