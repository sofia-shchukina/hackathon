package com.example.hackathon.util;

import com.example.hackathon.products.Product;
import com.example.hackathon.customers.Customer;
import com.example.hackathon.stores.Store;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.util.List;

public class JsonDataHandler {

    private final ObjectMapper objectMapper;

    public JsonDataHandler() {
        this.objectMapper = new ObjectMapper().findAndRegisterModules();
    }

    public List<Customer> readJsonDataForCustomers(String jsonData) {
        try {
            return objectMapper.readValue(jsonData, new TypeReference<List<Customer>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> readJsonDataForProducts(String jsonData) {
        try {
            return objectMapper.readValue(jsonData, new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Store> readJsonDataForStores(String jsonData) {
        try {
            return objectMapper.readValue(jsonData, new TypeReference<List<Store>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
