package com.example.yachtbookingapp.controller;

import com.example.yachtbookingapp.model.BookingEntityModel;
import com.example.yachtbookingapp.model.requestDTO.BookingRequest;
import com.example.yachtbookingapp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public ResponseEntity<BookingEntityModel> createBooking(@RequestBody BookingRequest bookingRequest) {
        BookingEntityModel booking = new BookingEntityModel();
        booking.setYacht(bookingRequest.getYacht());
        booking.setBookingDate(bookingRequest.getBookingDate());
        booking.setStartDate(bookingRequest.getStartDate());
        booking.setEndDate(bookingRequest.getEndDate());
        booking.setTotalPrice(bookingRequest.getTotalPrice());
        booking.setStatus(bookingRequest.getStatus());
        BookingEntityModel createdBooking = bookingService.createBooking(booking, bookingRequest.getDiscountId());
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
}
