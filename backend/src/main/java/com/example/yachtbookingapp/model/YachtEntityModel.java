package com.example.yachtbookingapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * Represents a yacht available for rent.<br>
 * (int) {@link #yachtId yachtId} - ID field.<br>
 * (String) {@link #name name} of yacht.<br>
 * (String) {@link #type type} of yacht.<br>
 * (BigDecimal) {@link #pricePerDay pricePerDay} for yacht per day.<br>*/
@Entity
@Table(name = "yacht")
@Setter
@Getter//"Lombok" annotation for getters, setters
@RequiredArgsConstructor
@NoArgsConstructor
public class YachtEntityModel {
    //Attributes:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "yacht_id")
    private int yachtId;
    @Column(name = "name", nullable = false)
    @NonNull private String name;
    @Column(name = "type", length = 100)
    @NonNull private String type;
    @Column(name = "price_per_day", nullable = false, precision = 10, scale = 2)
    @NonNull private BigDecimal pricePerDay;
}
