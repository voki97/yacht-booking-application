package com.example.yachtbookingapp.model.DTOs;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReportDTO {
    private int bookingId;
    private LocalDateTime generationDate = LocalDateTime.now();
}
