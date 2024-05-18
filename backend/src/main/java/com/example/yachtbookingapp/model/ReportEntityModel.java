package com.example.yachtbookingapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Represents a report generated for a booking.<br>
 * (int) {@link #reportId reportId} <br>
 * (BookingEntityModel) {@link #booking booking}<br>
 * (String) {@link #filePath filePath}<br>
 * (LocalDateTime) {@link #generationDate generationDate}
 */
@Entity
@Table(name = "report")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ReportEntityModel {
    //Attributes:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private int reportId;
    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false, foreignKey = @ForeignKey(name = "fk_booking_report"))
    @NonNull
    private BookingEntityModel booking;
    @Column(name = "file_path", nullable = false)
    @NonNull
    private String filePath;
    @Column(name = "generation_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @NonNull
    private LocalDateTime generationDate;
}
