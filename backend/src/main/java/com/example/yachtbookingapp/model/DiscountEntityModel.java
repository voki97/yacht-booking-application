package com.example.yachtbookingapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Represents a discount applicable to bookings.<br>
 * Class fields:<br>
 * (int) {@link #discountId discountId}<br>
 * (String) {@link #code code}<br>
 * (String) {@link #type type}<br>
 * (BigDecimal) {@link #value value}<br>
 */
@Entity
@Table(name = "discount")
@Data//"Lombok" annotation for getters, setters
@RequiredArgsConstructor
@NoArgsConstructor
public class DiscountEntityModel {
    //Attributes:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private int discountId;
    @Column(name = "code", nullable = false, length = 20)
    @NonNull
    private String code;
    @Column(name = "type", nullable = false, length = 20)
    @NonNull
    private String type;
    @Column(name = "value", nullable = false, precision = 10, scale = 2)
    @NonNull
    private BigDecimal value;
    //This is the representation of bookings, BookingEntityModel own this relationship.
    @ManyToMany(mappedBy = "discounts")
    private Set<BookingEntityModel> bookings;
}
