package com.example.yachtbookingapp.service;

import com.example.yachtbookingapp.model.ReportEntityModel;
import com.example.yachtbookingapp.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The ReportService class <br>
 * provides methods for CRUD
 * ({@link #createReport Create},
 * {@link #getAllReports Read},
 * {@link #updateReport Update},
 * {@link #deleteReportById Delete})
 * operations related to report entities.
 * It serves as a service layer component in the application.
 */
@Service
@RequiredArgsConstructor
public class ReportService {
    //Attributes:
    private final ReportRepository reportRepository;
    //Basic CRUD operations:
    //CREATE------------------------------------------------------------------------------------------------------------

    /**
     * Create a new report entity in the database.
     *
     * @param reportEntityModel The report entity to be created.
     * @return ReportEntityModel - the created report entity.
     */
    public ReportEntityModel createReport(ReportEntityModel reportEntityModel) {
        return reportRepository.save(reportEntityModel);
    }
    //READ--------------------------------------------------------------------------------------------------------------
    //all:

    /**
     * Retrieve a list of all report entities from the database.
     *
     * @return A list of all report entities. Returns an empty list if no reports are found.
     */
    public List<ReportEntityModel> getAllReports() {
        return reportRepository.findAll();
    }
    //specific by ID:

    /**
     * Retrieves a specific report entity from the database by its ID.
     *
     * @param reportId The ID of the report entity to retrieve.
     * @return ReportEntityModel The report entity with the specified ID.
     * @throws IllegalArgumentException If no report entity is found with the specified ID.
     */
    public ReportEntityModel getReportById(int reportId) {
        return reportRepository.findById(reportId).orElseThrow(() ->
                new IllegalArgumentException("Report with ID " + reportId + " not found!"));
    }
    //UPDATE------------------------------------------------------------------------------------------------------------

    /**
     * Updates an existing report entity in the database.
     *
     * @param reportId         The ID of the report entity to update.
     * @param reportUpdateData The updated data for the report entity.
     * @return The updated report entity.
     * @throws IllegalArgumentException If no report entity is found with the specified ID.
     */
    public ReportEntityModel updateReport(int reportId, ReportEntityModel reportUpdateData) {
        ReportEntityModel existingReport = reportRepository.findById(reportId).orElseThrow(() ->
                new IllegalArgumentException("Report with ID " + reportId + " not found!"));
        existingReport.setBooking(reportUpdateData.getBooking());
        existingReport.setGenerationDate(reportUpdateData.getGenerationDate());
        return reportRepository.save(existingReport);
    }
    //DELETE------------------------------------------------------------------------------------------------------------

    /**
     * Deletes a report entity from the database by its ID.
     *
     * @param reportId The ID of the report entity to delete.
     */
    public void deleteReportById(int reportId) {
        reportRepository.deleteById(reportId);
    }

    //CUSTOM METHODS:
    //generate report:

}
