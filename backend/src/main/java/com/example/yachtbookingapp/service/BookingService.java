package com.example.yachtbookingapp.service;

import com.example.yachtbookingapp.model.BookingEntityModel;
import com.example.yachtbookingapp.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The BookingService class <br>
 * provides methods for CRUD
 * ({@link #createBooking Create},
 * {@link #getAllBookings Read},
 * {@link #updateBooking Update},
 * {@link #deleteBooking Delete}) operations related to booking entities.
 * It serves as a service layer component in the application.
 */
@Service
@RequiredArgsConstructor
public class BookingService {
    //Attributes:
    private final BookingRepository bookingRepository;

    //Basic CRUD methods:
    //CREATE------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new booking entity in the database.
     *
     * @param #booking the booking entity to be created.
     * @return BookingEntityModel the created booking entity.
     */
    public BookingEntityModel createBooking(BookingEntityModel booking) {
        return bookingRepository.save(booking);
    }

    //READ--------------------------------------------------------------------------------------------------------------
    //all:

    /**
     * Retrieves a list of all booking entities from the database.
     *
     * @return A list of all booking entities. Returns an empty list if no bookings are found.
     */
    public List<BookingEntityModel> getAllBookings() {
        return bookingRepository.findAll();
    }

    //specific by ID:

    /**
     * Retrieves a specific booking entity from the database by its ID.
     *
     * @param bookingId The ID of the booking entity to retrieve.
     * @return BookingEntityModel The booking entity with the specified ID.
     * @throws IllegalArgumentException If no booking entity is found with the specified ID.
     */
    public BookingEntityModel getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(() ->
                new IllegalArgumentException("Booking with id " + bookingId + " not found!"));
    }

    //UPDATE------------------------------------------------------------------------------------------------------------

    /**
     * Updates an existing booking entity in the database.
     *
     * @param bookingId         The ID of the booking entity to update.
     * @param bookingUpdateData The updated data for the booking entity.
     * @return BookingEntityModel The updated booking entity.
     * @throws IllegalArgumentException If no booking entity is found with the specified ID.
     */
    public BookingEntityModel updateBooking(int bookingId, BookingEntityModel bookingUpdateData) {
        BookingEntityModel existingBookingData = bookingRepository.findById(bookingId).orElseThrow(() ->
                new IllegalArgumentException("Booking with id " + bookingId + " not found!"));
        existingBookingData.setYacht(bookingUpdateData.getYacht());
        existingBookingData.setBookingDate(bookingUpdateData.getBookingDate());
        existingBookingData.setStartDate(bookingUpdateData.getStartDate());
        existingBookingData.setEndDate(bookingUpdateData.getEndDate());
        existingBookingData.setTotalPrice(bookingUpdateData.getTotalPrice());
        existingBookingData.setStatus(bookingUpdateData.getStatus());
        return bookingRepository.save(existingBookingData);
    }

    //DELETE------------------------------------------------------------------------------------------------------------

    /**
     * Deletes a booking entity from the database by its ID.
     *
     * @param bookingId The ID of the booking entity to delete.
     */
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
