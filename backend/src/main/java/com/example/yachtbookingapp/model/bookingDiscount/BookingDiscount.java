package com.example.yachtbookingapp.model.bookingDiscount;

import com.example.yachtbookingapp.model.BookingEntityModel;
import com.example.yachtbookingapp.model.DiscountEntityModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking_discount")
@Setter
@Getter
public class BookingDiscount {
    @EmbeddedId
    private BookingDiscountKey id;


    @MapsId("bookingId")
    @JsonBackReference
    @ManyToOne
    private BookingEntityModel booking;


    @MapsId("discountId")
    @JsonBackReference
    @ManyToOne
    private DiscountEntityModel discount;

    public BookingDiscount() {
    }

    public BookingDiscount(BookingDiscountKey id, BookingEntityModel booking, DiscountEntityModel discount) {
        this.id = id;
        this.booking = booking;
        this.discount = discount;
    }
}
