package com.example.hackathon.requests;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ShoppingRequestRepository extends JpaRepository<ShoppingRequest, String> {


}
