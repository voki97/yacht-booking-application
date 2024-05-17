package com.example.yachtbookingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

/**Represents a discount applicable to bookings.*/
@Entity
@Table(name = "discount")
@Data//"Lombok" annotation for getters, setters
@AllArgsConstructor
@NoArgsConstructor
public class DiscountEntityModel {
    //Attributes:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private int discountId;
    @Column(name = "code", nullable = false, length = 20)
    private String code;
    @Column(name = "type", nullable = false, length = 20)
    private String type;
    @Column(name = "value", nullable = false, precision = 10, scale = 2)
    private BigDecimal value;
    //This is the representation of bookings, BookingEntityModel own this relationship.
    @ManyToMany(mappedBy = "discounts")
    private Set<BookingEntityModel> bookings;
}
