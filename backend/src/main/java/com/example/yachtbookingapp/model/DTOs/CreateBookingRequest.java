package com.example.yachtbookingapp.model.DTOs;

import com.example.yachtbookingapp.model.YachtEntityModel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class CreateBookingRequest {
        private YachtEntityModel yacht;
        private LocalDateTime bookingDate = LocalDateTime.now();
        private LocalDate startDate;
        private LocalDate endDate;
        private BigDecimal totalPrice;
        private String status;
        private int discountId;
}
