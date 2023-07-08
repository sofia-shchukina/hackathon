package com.example.hackathon.customers;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name="customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer{
        @Id
        int id;
         int number;
         String firstName;
         String lastName;
         String phoneNumber;
         String emailAddress;
        LocalDate birthday;
         @Embedded
         Address address;
}

