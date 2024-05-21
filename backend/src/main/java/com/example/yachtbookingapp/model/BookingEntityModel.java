package com.example.yachtbookingapp.model;

import com.example.yachtbookingapp.model.bookingDiscount.BookingDiscount;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Represents a booking made for renting a yacht.<br>
 * Class fields:<br>
 * (int) {@link #bookingId bookingId}<br>
 * (YachtEntityModel) {@link #yacht yacht}<br>
 * (LocalDateTime) {@link #bookingDate bookind date}<br>
 * (LocalDate) {@link #startDate startDate}<br>
 * (LocalDate) {@link #endDate endDate}<br>
 * (BigDecimal) {@link #totalPrice totalPrice}<br>
 * (String) {@link #status status}<br>
 */
@Entity
@Table(name = "booking")
@Setter
@Getter//"Lombok" annotation for getters, setters
@RequiredArgsConstructor//Fields with @NonNull annotation will be parameters of constructor.
@NoArgsConstructor
public class BookingEntityModel {
    //Attributes:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;
    @ManyToOne
    @JoinColumn(name = "yacht_id", nullable = false, foreignKey = @ForeignKey(name = "fk_yacht_booking"))
    @NonNull
    private YachtEntityModel yacht;
    @Column(name = "booking_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime bookingDate;
    @Column(name = "start_date", nullable = false)
    @NonNull
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    @NonNull
    private LocalDate endDate;
    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    @NonNull
    private BigDecimal totalPrice;
    @Column(name = "status", nullable = false, length = 20)
    @NonNull
    private String status;
    //One-To-One relationship is owned by ReportEntityModel class, and relationship must be represented also here:
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private ReportEntityModel report;
    //Representation of discounts:
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<BookingDiscount> bookingDiscounts;
}
