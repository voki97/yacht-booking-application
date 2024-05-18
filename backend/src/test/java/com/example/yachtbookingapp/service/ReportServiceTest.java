package com.example.yachtbookingapp.service;

import com.example.yachtbookingapp.model.BookingEntityModel;
import com.example.yachtbookingapp.model.ReportEntityModel;
import com.example.yachtbookingapp.repository.ReportRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ReportServiceTest {
    private AutoCloseable closable;
    @Mock
    private ReportRepository reportRepository;
    @InjectMocks
    private ReportService reportService;

    @BeforeEach
    public void setUp() {
        closable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closable.close();
    }

    //Test Basic CRUD methods:
    //CREATE------------------------------------------------------------------------------------------------------------
    @Test
    public void testCreateReport() {
        //object of type Report:
        ReportEntityModel createReport = new ReportEntityModel();
        //mock:
        when(reportRepository.save(createReport)).thenReturn(createReport);
        //call the method from service:
        ReportEntityModel result = reportService.createReport(createReport);
        //compare and assert:
        assertEquals(createReport, result);
        //verify that save() was invoked once:
        verify(reportRepository, times(1)).save(createReport);
    }

    //READ--------------------------------------------------------------------------------------------------------------
    //all:
    @Test
    public void testReadAllReports() {
        //simulate 3 reports in database:
        ReportEntityModel report1 = new ReportEntityModel();
        ReportEntityModel report2 = new ReportEntityModel();
        ReportEntityModel report3 = new ReportEntityModel();
        //put reports in an array list:
        List<ReportEntityModel> expected = new ArrayList<>();
        expected.add(report1);
        expected.add(report2);
        expected.add(report3);
        //mock:
        when(reportRepository.findAll()).thenReturn(expected);
        //call the method from service:
        List<ReportEntityModel> result = reportService.getAllReports();
        //assert and compare expected and result:
        assertEquals(expected, result);
        //verify that findAll() method is invoked:
        verify(reportRepository, times(1)).findAll();
    }

    //By ID:
    @Test
    public void testReadExistingReportById() {
        //new report object with valid ID:
        ReportEntityModel existingReport = new ReportEntityModel();
        existingReport.setReportId(1);
        //mock:
        when(reportRepository.findById(existingReport.getReportId())).thenReturn(Optional.of(existingReport));
        //call the method from service class:
        ReportEntityModel result = reportService.getReportById(existingReport.getReportId());
        //assert and compare a result and existing report:
        assertEquals(existingReport, result);
        //verify that findById() is invoked once:
        verify(reportRepository, times(1)).findById(existingReport.getReportId());
    }

    @Test
    public void testReadNonExistingReportById() {
        //assert that exception is thrown when service class perform operation with non-existing ID:
        assertThrows(IllegalArgumentException.class, () -> reportService.getReportById(-1));
        //verify that findById is invoked once:
        verify(reportRepository, times(1)).findById(-1);
    }

    //UPDATE------------------------------------------------------------------------------------------------------------

    @Test
    public void testUpdateExistingReport() {
        //an existing id:
        int reportId = 1;
        //existing Report entity model:
        ReportEntityModel existingReport = new ReportEntityModel();
        existingReport.setReportId(reportId);
        //report entity model with data for update:
        LocalDateTime generationDate = LocalDateTime.now();
        ReportEntityModel updatedReport = new ReportEntityModel(
                new BookingEntityModel(), "path/to/file/test", generationDate
        );
        updatedReport.setReportId(reportId);
        //mock:
        when(reportRepository.findById(existingReport.getReportId())).thenReturn(Optional.of(existingReport));
        when(reportRepository.save(updatedReport)).thenReturn(updatedReport);
        //call the method from service class:
        ReportEntityModel result = reportService.updateReport(reportId, updatedReport);
        //compare updatedReport and result, assert that and verify that findByID() and save() from repository are invoked once each:
        assertEquals(updatedReport, result);
        verify(reportRepository, times(1)).findById(existingReport.getReportId());
        verify(reportRepository, times(1)).save(updatedReport);
    }

    @Test
    public void testUpdateNonExistingReport() {
        //assert that Exception will be thrown when service try to update a non-existing report:
        assertThrows(IllegalArgumentException.class, () -> reportService.updateReport(-1, new ReportEntityModel()));
        //verify that findByID() is invoked once and save() is never invoked:
        verify(reportRepository, times(1)).findById(-1);
        verify(reportRepository, never()).save(any(ReportEntityModel.class));
    }

    //DELETE------------------------------------------------------------------------------------------------------------

    @Test
    public void testDeleteReport() {
        int reportId = 1;
        //call the method:
        reportService.deleteReportById(reportId);
        //verify that method is invoked once:
        verify(reportRepository, times(1)).deleteById(reportId);
    }
}
