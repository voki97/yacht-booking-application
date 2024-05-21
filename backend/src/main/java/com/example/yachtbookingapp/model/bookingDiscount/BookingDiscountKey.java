package com.example.yachtbookingapp.model.bookingDiscount;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
@Setter
@Getter
@Embeddable
public class BookingDiscountKey implements Serializable {
    private int bookingId;
    private int discountId;

    public BookingDiscountKey() {
    }

    public BookingDiscountKey(int bookingId, int discountId) {
        this.bookingId = bookingId;
        this.discountId = discountId;
    }
}