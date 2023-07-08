package com.example.hackathon.util;

import com.example.hackathon.users.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.util.List;

public class JsonDataHandler {

    private final ObjectMapper objectMapper;

    public JsonDataHandler() {
        this.objectMapper = new ObjectMapper().findAndRegisterModules();
    }

    public List<Customer> readJsonData(String jsonData) {
        try {
            return objectMapper.readValue(jsonData, new TypeReference<List<Customer>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
