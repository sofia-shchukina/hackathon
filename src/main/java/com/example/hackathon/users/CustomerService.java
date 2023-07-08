package com.example.hackathon.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> showAllUsers() {
        return customerRepository.findAll();
    }

    public void saveAllCustomers (List<Customer> allCustomers) {
        customerRepository.saveAll(allCustomers);
    }

}
