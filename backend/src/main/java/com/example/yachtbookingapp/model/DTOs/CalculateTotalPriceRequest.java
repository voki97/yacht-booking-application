package com.example.yachtbookingapp.model.DTOs;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CalculateTotalPriceRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal pricePerDay;
}
