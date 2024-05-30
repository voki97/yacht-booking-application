package com.example.yachtbookingapp.model;

import com.example.yachtbookingapp.model.bookingDiscount.BookingDiscount;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

/**
 * Represents a discount applicable to booking.<br>
 * Class fields:<br>
 * (int) {@link #discountId discountId}<br>
 * (String) {@link #code code}<br>
 * (String) {@link #type type}<br>
 * (BigDecimal) {@link #value value}<br>
 */
@Entity
@Table(name = "discount")
@Setter
@Getter//"Lombok" annotation for getters, setters
@RequiredArgsConstructor
@NoArgsConstructor
public class DiscountEntityModel {
    //Attributes:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private int discountId;
    @Column(name = "code", nullable = false, length = 20, unique = true)
    @NonNull
    private String code;
    @Column(name = "type", nullable = false, length = 20)
    @NonNull
    private String type;
    @Column(name = "value", nullable = false, precision = 5, scale = 2)
    @NonNull
    private BigDecimal value;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    //This is the representation of booking, BookingEntityModel own this relationship.
    @OneToMany(mappedBy = "discount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<BookingDiscount> discountBookings;
}
