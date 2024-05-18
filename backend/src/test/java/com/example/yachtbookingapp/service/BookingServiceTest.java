package com.example.yachtbookingapp.service;

import com.example.yachtbookingapp.model.BookingEntityModel;
import com.example.yachtbookingapp.model.YachtEntityModel;
import com.example.yachtbookingapp.repository.BookingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookingServiceTest {
    private AutoCloseable closeable;
    @Mock
    private BookingRepository bookingRepository;
    @InjectMocks
    private BookingService bookingService;
    @BeforeEach
    public void setUp(){
        closeable = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }
    //Tests:
    //CRUD methods:
    //CREATE------------------------------------------------------------------------------------------------------------
    @Test
    public void testAddBooking(){
        //attributes for testing:
        LocalDateTime bookingDate = LocalDateTime.now();
        //booking entity model:
        BookingEntityModel expected = new BookingEntityModel(
                new YachtEntityModel(), bookingDate, LocalDate.now(),
                LocalDate.now().plusDays(1), BigDecimal.valueOf(100.00), "pending"
        );
        //mock:
        when(bookingRepository.save(any(BookingEntityModel.class))).thenReturn(expected);
        //call the service method:
        BookingEntityModel result = bookingService.createBooking(expected);
        //assert and verify that repository invoked:
        assertEquals(expected, result);
        verify(bookingRepository, times(1)).save(expected);
    }
    //READ--------------------------------------------------------------------------------------------------------------
    @Test
    public void testGetAllBookings(){
        //Booking entities that simulate multiple stored records:
        BookingEntityModel booking1 = new BookingEntityModel();
        BookingEntityModel booking2 = new BookingEntityModel();
        BookingEntityModel booking3 = new BookingEntityModel();
        //add those to array list:
        List<BookingEntityModel> expected = new ArrayList<>();
        expected.add(booking1);
        expected.add(booking2);
        expected.add(booking3);
        //mock:
        when(bookingRepository.findAll()).thenReturn(expected);
        //call service method:
        List<BookingEntityModel> result = bookingService.getAllBookings();
        //assert and verify that repository invoked findAll() once:
        assertEquals(expected, result);
        verify(bookingRepository, times(1)).findAll();
    }
    @Test
    public void testGetExistingBookingById(){
        //prep:
        int bookingId = 1;
        BookingEntityModel expected = new BookingEntityModel();
        expected.setBookingId(bookingId);
        //mock:
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(expected));
        //call service method:
        BookingEntityModel result = bookingService.getBookingById(bookingId);
        //assert and verify that method from the repository is invoked once:
        assertEquals(expected, result);
        verify(bookingRepository, times(1)).findById(bookingId);
    }
    @Test
    public void testGetNonExistingBookingById(){
        //mock:
        when(bookingRepository.findById(anyInt())).thenReturn(Optional.empty());
        //assert and call the method from service:
        assertThrows(IllegalArgumentException.class, () -> bookingService.getBookingById(1));
    }
    //UPDATE------------------------------------------------------------------------------------------------------------
    @Test
    public void testUpdateExistingBooking(){
        //prep:
        int bookingId = 1;
        BookingEntityModel expected = new BookingEntityModel();
        expected.setBookingId(bookingId);
        BookingEntityModel updateData = new BookingEntityModel();
        updateData.setYacht(new YachtEntityModel());
        updateData.setBookingDate(LocalDateTime.now());
        updateData.setStartDate(LocalDate.now());
        updateData.setEndDate(LocalDate.now().plusDays(1));
        updateData.setTotalPrice(BigDecimal.valueOf(100.00));
        updateData.setStatus("Active");
        //mock:
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(expected));
        when(bookingRepository.save(any(BookingEntityModel.class))).thenReturn(expected);
        //call the method from service:
        BookingEntityModel result = bookingService.updateBooking(bookingId, updateData);
        //assert and verify:
        assertEquals(expected, result);
        verify(bookingRepository, times(1)).findById(bookingId);
        verify(bookingRepository, times(1)).save(expected);
    }
    @Test
    public void testUpdateNonExistingBooking(){
        //mock:
        when(bookingRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> bookingService.updateBooking(-1, new BookingEntityModel()));
    }
    //DELETE------------------------------------------------------------------------------------------------------------
    @Test
    public void testDeleteBooking(){
        //prep:
        int bookingId = 1;
        //call the method from service:
        bookingService.deleteBooking(bookingId);
        verify(bookingRepository, times(1)).deleteById(bookingId);
    }
}
