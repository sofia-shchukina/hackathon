package com.example.hackathon.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name="shoppingrequest")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingRequest {
    @Id
    String id;
    String nameOfTheRequester;
    @ElementCollection
    List<OrderItem> shoppinglist;

    String status;

    LocalDateTime deadline;
}
