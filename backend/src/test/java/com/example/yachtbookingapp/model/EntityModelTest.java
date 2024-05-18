package com.example.yachtbookingapp.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**This test class provides basic entity model tests.*/
public class EntityModelTest {
    /**
     * Test empty constructors, getters, and setters for entity models.
     * Verifies that empty constructors initialize fields properly,
     * and getters/setters work as expected.
     */
    @Test
    public void testEmptyConstructorsGettersSetters(){
        //Entity models, no argument constructors:
        YachtEntityModel yacht = new YachtEntityModel();
        BookingEntityModel booking = new BookingEntityModel();
        ReportEntityModel report = new ReportEntityModel();
        DiscountEntityModel discount = new DiscountEntityModel();
        //Setters:
        //yacht:
        yacht.setYachtId(1);
        yacht.setName("Yacht Name");
        yacht.setPricePerDay(BigDecimal.valueOf(1000.00));
        yacht.setType("Yacht Type");
        //booking:
        booking.setBookingId(1);
        booking.setYacht(yacht);
        LocalDateTime dateTime = LocalDateTime.now();
        booking.setBookingDate(dateTime);
        LocalDate startDate = LocalDate.now().minusDays(1);
        booking.setStartDate(startDate);
        LocalDate endDate = LocalDate.now().plusDays(1);
        booking.setEndDate(endDate);
        booking.setTotalPrice(BigDecimal.valueOf(1000.00));
        booking.setStatus("pending");

        //report:
        report.setReportId(1);
        report.setBooking(booking);
        report.setFilePath("path/to/report");
        LocalDateTime generationDate = LocalDateTime.now();
        report.setGenerationDate(generationDate);
        //discount:
        discount.setDiscountId(1);
        discount.setCode("1234567890");
        discount.setType("VIP");
        discount.setValue(BigDecimal.valueOf(100.00));
        Set<BookingEntityModel> bookings = new HashSet<>();
        discount.setBookings(bookings);

        //Assert with getters:
        //Yacht:
        assertEquals(1, yacht.getYachtId());
        assertEquals("Yacht Name", yacht.getName());
        assertEquals(BigDecimal.valueOf(1000.00), yacht.getPricePerDay());
        assertEquals("Yacht Type", yacht.getType());
        //Booking:
        assertEquals(1, booking.getBookingId());
        assertEquals(yacht, booking.getYacht());
        assertEquals(dateTime, booking.getBookingDate());
        assertEquals(startDate, booking.getStartDate());
        assertEquals(endDate, booking.getEndDate());
        assertEquals(BigDecimal.valueOf(1000.00), booking.getTotalPrice());
        assertEquals("pending", booking.getStatus());
        //Report:
        assertEquals(1, report.getReportId());
        assertEquals(booking, report.getBooking());
        assertEquals("path/to/report", report.getFilePath());
        assertEquals(generationDate, report.getGenerationDate());
        //Discount:
        assertEquals(1, discount.getDiscountId());
        assertEquals("1234567890", discount.getCode());
        assertEquals("VIP", discount.getType());
        assertEquals(BigDecimal.valueOf(100.00), discount.getValue());
        assertEquals(bookings, discount.getBookings());
    }
    /**
     * Test all-argument constructors and toString() methods for entity models.
     * Verifies that all-argument constructors initialize fields properly,
     * and toString() methods return expected string representations.
     */
    @Test
    public void testAllArgumentConstructorsToString(){
        //Entity models, all argument constructors:
        //Yacht:
        YachtEntityModel yacht = new YachtEntityModel(
                "Yacht Name", "Yacht type", BigDecimal.valueOf(1000.00)
        );
        //Booking:
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate startDate = LocalDate.now().minusDays(1);
        LocalDate endDate = LocalDate.now().plusDays(1);
        BookingEntityModel booking = new BookingEntityModel(
                yacht, dateTime, startDate, endDate, BigDecimal.valueOf(1000.00), "pending"
        );
        //report:
        LocalDateTime generationDate = LocalDateTime.now();
        ReportEntityModel report = new ReportEntityModel(
                booking,"path/to/report", generationDate);
        //discount:
        DiscountEntityModel discount = new DiscountEntityModel(
                "1234567890", "VIP", BigDecimal.valueOf(100.00)
        );
        //assert with toString():
        assertEquals("YachtEntityModel(yachtId=1, name=Yacht Name, type=Yacht type, pricePerDay=1000.0)",
                yacht.toString());
        assertEquals("BookingEntityModel(bookingId=1, yacht=YachtEntityModel(yachtId=1, name=Yacht Name, type=Yacht type, pricePerDay=1000.0), bookingDate="+dateTime+", startDate=2024-05-16, endDate=2024-05-18, totalPrice=1000.0, status=pending, report=ReportEntityModel(reportId=0, booking=null, filePath=null, generationDate=null), discounts=[])",
                booking.toString());
        assertEquals("ReportEntityModel(reportId=1, booking=BookingEntityModel(bookingId=1, yacht=YachtEntityModel(yachtId=1, name=Yacht Name, type=Yacht type, pricePerDay=1000.0), bookingDate="+dateTime+", startDate=2024-05-16, endDate=2024-05-18, totalPrice=1000.0, status=pending, report=ReportEntityModel(reportId=0, booking=null, filePath=null, generationDate=null), discounts=[]), filePath=path/to/report, generationDate="+generationDate+")",
                report.toString());
        assertEquals("DiscountEntityModel(discountId=1, code=1234567890, type=VIP, value=100.0, bookings=[])",
                discount.toString());
    }
}
