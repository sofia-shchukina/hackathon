package com.example.hackathon.products;

import com.example.hackathon.requests.ShoppingRequest;
import com.example.hackathon.users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
