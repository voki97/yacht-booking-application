package com.example.yachtbookingapp.controller;

import com.example.yachtbookingapp.model.BookingEntityModel;
import com.example.yachtbookingapp.model.DTOs.ReportDTO;
import com.example.yachtbookingapp.model.ReportEntityModel;
import com.example.yachtbookingapp.repository.BookingRepository;
import com.example.yachtbookingapp.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The ReportController class <br>
 * is responsible for handling HTTP requests related to report operations such as:<br>
 * {@link #createReport creating},
 * {@link #getAllReports reading},
 * {@link #updateReport updating}, and
 * {@link #deleteReport deleting} report records.
 * It serves as a REST controller in the application.
 */
@RestController
@RequestMapping("/api/report")
@CrossOrigin
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final BookingRepository bookingRepository;

    //ENDPOINTS:
    //CREATE------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new report record.
     */
    @PostMapping ("/create")
    public ResponseEntity<ReportEntityModel> createReport(@RequestBody ReportDTO reportRequest) {
        BookingEntityModel booking = bookingRepository.findById(reportRequest.getBookingId()).orElseThrow(()->
                new IllegalArgumentException("Booking not found"));
        ReportEntityModel report = new ReportEntityModel();
        report.setBooking(booking);
        report.setGenerationDate(reportRequest.getGenerationDate());
        ReportEntityModel createdReport = reportService.createReport(report);
        return ResponseEntity.ok(createdReport);
    }

    //READ--------------------------------------------------------------------------------------------------------------
    //All records:

    /**
     * Retrieves all report records.
     */
    @GetMapping("/all")
    public ResponseEntity<List<ReportEntityModel>> getAllReports() {
        List<ReportEntityModel> allReports = reportService.getAllReports();
        return ResponseEntity.ok(allReports);
    }
    //By ID:

    /**
     * Retrieves a specific report record by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReportEntityModel> getReportById(@PathVariable("id") int id) {
        ReportEntityModel report = reportService.getReportById(id);
        return ResponseEntity.ok(report);
    }

    //UPDATE------------------------------------------------------------------------------------------------------------

    /**
     * Updates an existing report record.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<ReportEntityModel> updateReport(@PathVariable("id") int id, @RequestBody ReportEntityModel updateData) {
        ReportEntityModel report = reportService.updateReport(id, updateData);
        return ResponseEntity.ok(report);
    }

    //DELETE------------------------------------------------------------------------------------------------------------

    /**
     * Deletes a report record.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ReportEntityModel> deleteReport(@PathVariable("id") int id) {
        reportService.deleteReportById(id);
        return ResponseEntity.noContent().build();
    }
}
