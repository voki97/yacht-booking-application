package com.example.yachtbookingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Represents a yacht available for rent.*/
@Entity
@Table(name = "yacht")
@Data//"Lombok" annotation for getters, setters
@AllArgsConstructor
@NoArgsConstructor
public class YachtEntityModel {
    //Attributes:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "yacht_id")
    private int yachtId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type", length = 100)
    private String type;
    @Column(name = "price_per_day", nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerDay;
}
