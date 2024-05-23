package com.example.yachtbookingapp.controller;

import com.example.yachtbookingapp.model.BookingEntityModel;
import com.example.yachtbookingapp.model.DTOs.CalculateTotalPriceRequest;
import com.example.yachtbookingapp.model.DTOs.CreateBookingRequest;
import com.example.yachtbookingapp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * The BookingController class <br>
 * is responsible for handling HTTP requests related to booking operations such as:<br>
 * {@link #createBooking creating},
 * {@link #getAllBookings reading},
 * {@link #updateBooking updating}, and
 * {@link #deleteBooking deleting} booking records.
 * It serves as a REST controller in the application.
 */
@RestController
@RequestMapping("/api/booking")
@CrossOrigin
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    //ENDPOINTS:
    //CREATE------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new booking record.
     */
    @PostMapping("/create")
    public ResponseEntity<BookingEntityModel> createBooking(@RequestBody CreateBookingRequest createBookingRequest) {
        BookingEntityModel booking = new BookingEntityModel();
        booking.setYacht(createBookingRequest.getYacht());
        booking.setBookingDate(createBookingRequest.getBookingDate());
        booking.setStartDate(createBookingRequest.getStartDate());
        booking.setEndDate(createBookingRequest.getEndDate());
        booking.setTotalPrice(createBookingRequest.getTotalPrice());
        booking.setStatus(createBookingRequest.getStatus());
        BookingEntityModel createdBooking = bookingService.createBooking(booking, createBookingRequest.getDiscountId());
        return ResponseEntity.ok(createdBooking);
    }

    //READ--------------------------------------------------------------------------------------------------------------
    //All records:

    /**
     * Retrieves all booking records.
     */
    @GetMapping("/all")
    public ResponseEntity<List<BookingEntityModel>> getAllBookings() {
        List<BookingEntityModel> allBookings = bookingService.getAllBookings();
        return ResponseEntity.ok(allBookings);
    }

    //By ID:

    /**
     * Retrieves a specific booking record by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookingEntityModel> getBookingById(@PathVariable("id") int id) {
        BookingEntityModel bookingEntityModel = bookingService.getBookingById(id);
        return ResponseEntity.ok(bookingEntityModel);
    }

    //UPDATE------------------------------------------------------------------------------------------------------------

    /**
     * Updates an existing booking record.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<BookingEntityModel> updateBooking(@PathVariable("id") int id, @RequestBody BookingEntityModel updateData) {
        bookingService.updateBooking(id, updateData);
        return ResponseEntity.ok(updateData);
    }

    //DELETE------------------------------------------------------------------------------------------------------------

    /**
     * Deletes a booking record.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookingEntityModel> deleteBooking(@PathVariable("id") int id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    //CUSTOM METHODS:
    //Calculate total price:
    @PostMapping("/total_price")
    public ResponseEntity<BigDecimal> calculateTotalPrice(@RequestBody CalculateTotalPriceRequest request) {
        BigDecimal totalPrice = bookingService.calculateTotalPrice(request);
        return ResponseEntity.ok(totalPrice);
    }
}
