package com.example.hackathon.stores;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="store")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store {
    @Id
    Integer id;
    @Embedded
    ShopAddress address;


    List<String> services;

    @ElementCollection
    List<OpeningHours> openingHours;
}
