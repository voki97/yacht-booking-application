package com.example.yachtbookingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**Represents a report generated for a booking.*/
@Entity
@Table(name = "report")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportEntityModel {
    //Attributes:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private int reportId;
    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false, foreignKey = @ForeignKey(name = "fk_booking_report"))
    private BookingEntityModel booking;
    @Column(name = "file_path", nullable = false)
    private String filePath;
    @Column(name = "generation_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime generationDate;
}
