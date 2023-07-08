package com.example.hackathon.products;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product{
    @Id
    Integer id;
    String name;
    String brand;
    String pack;
    Double price;
    String eans;
}

