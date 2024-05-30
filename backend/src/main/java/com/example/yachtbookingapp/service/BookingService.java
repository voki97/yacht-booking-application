package com.example.yachtbookingapp.service;

import com.example.yachtbookingapp.model.BookingEntityModel;
import com.example.yachtbookingapp.model.DTOs.CalculateTotalPriceRequest;
import com.example.yachtbookingapp.model.DiscountEntityModel;
import com.example.yachtbookingapp.model.bookingDiscount.BookingDiscount;
import com.example.yachtbookingapp.model.bookingDiscount.BookingDiscountKey;
import com.example.yachtbookingapp.repository.BookingRepository;
import com.example.yachtbookingapp.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;
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
    private final DiscountRepository discountRepository;

    //Basic CRUD methods:
    //CREATE------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new booking entity in the database.
     *
     * @param #booking the booking entity to be created.
     * @param #discountId set of discount ID if available, to insert into booking_discount table.
     * @return BookingEntityModel the created booking entity.
     */
    public BookingEntityModel createBooking(BookingEntityModel booking, int discountId) {
        if(discountId!=0){
            DiscountEntityModel discount = discountRepository.findById(discountId).orElseThrow(()->
                    new RuntimeException("Discount with ID: "+discountId+" not found!"));
            BookingDiscountKey key = new BookingDiscountKey(booking.getBookingId(), discount.getDiscountId());
            BookingDiscount bookingDiscount = new BookingDiscount(key, booking, discount);
            if(booking.getBookingDiscounts()!= null){
                booking.getBookingDiscounts().add(bookingDiscount);
            }
            if(discount.getDiscountBookings()!= null){
                discount.getDiscountBookings().add(bookingDiscount);
            }
            bookingRepository.save(booking);
            discountRepository.save(discount);
            return booking;
        }
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

    //Custom methods:
    //Calculate total price:
    public BigDecimal calculateTotalPrice(CalculateTotalPriceRequest request) {
        BigDecimal totalPrice;
        long days = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());
        if(request.getDiscountId()!=0){
            DiscountEntityModel appliedDiscount = discountRepository.findById(request.getDiscountId()).orElseThrow(()->
                new IllegalArgumentException("Discount with ID: "+request.getDiscountId()+" not found!"));
            //50% off: totalPrice: 100, 50/100=0.50, 0.50*100 = 50, 100-50= 50
            BigDecimal discount = appliedDiscount.getValue().divide(BigDecimal.valueOf(100.00), 2, RoundingMode.HALF_UP);
            totalPrice = new BigDecimal(days).multiply(request.getPricePerDay());
            BigDecimal discountValue = totalPrice.multiply(discount);
            totalPrice = totalPrice.subtract(discountValue);
        }else{
            totalPrice = new BigDecimal(days).multiply(request.getPricePerDay());
        }
        return totalPrice;
    }
}
