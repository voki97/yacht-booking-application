package com.example.yachtbookingapp.service;

import com.example.yachtbookingapp.model.DiscountEntityModel;
import com.example.yachtbookingapp.repository.DiscountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DiscountServiceTest {
    private AutoCloseable closeable;
    @Mock
    private DiscountRepository discountRepository;
    @InjectMocks
    private DiscountService discountService;

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    //CREATE------------------------------------------------------------------------------------------------------------

    @Test
    public void testCreateDiscount() {
        //prep:
        DiscountEntityModel discountEntityModel = new DiscountEntityModel();
        //mock:
        when(discountRepository.save(any(DiscountEntityModel.class))).thenReturn(discountEntityModel);
        //call the method:
        DiscountEntityModel result = discountService.createDiscount(discountEntityModel);
        //assert and verify that repository invoked save() once:
        assertEquals(discountEntityModel, result);
        verify(discountRepository, times(1)).save(discountEntityModel);
    }

    //READ--------------------------------------------------------------------------------------------------------------
    //all:
    @Test
    public void testFindAllDiscounts(){
        //prep:
        DiscountEntityModel discount1 = new DiscountEntityModel();
        DiscountEntityModel discount2 = new DiscountEntityModel();
        DiscountEntityModel discount3 = new DiscountEntityModel();
        //populate an array list (List is return value of the method):
        List<DiscountEntityModel> discounts = new ArrayList<>();
        discounts.add(discount1);
        discounts.add(discount2);
        discounts.add(discount3);
        //mock:
        when(discountRepository.findAll()).thenReturn(discounts);
        //call the method from service class:
        List<DiscountEntityModel> result = discountService.getAllDiscounts();
        //assert and verify that findAll() is invoked once in discountRepository.class
        assertEquals(discounts, result);
        verify(discountRepository, times(1)).findAll();
    }

    //By ID:
    @Test
    public void testFindExistingDiscountById() {
        //prep:
        int discountId = 1;
        DiscountEntityModel existing = new DiscountEntityModel();
        existing.setDiscountId(discountId);
        //mock:
        when(discountRepository.findById(discountId)).thenReturn(Optional.of(existing));
        //call the method:
        DiscountEntityModel result = discountService.getDiscountById(discountId);
        //assert and verify that findById() is invoked once:
        assertEquals(existing, result);
        verify(discountRepository, times(1)).findById(discountId);
    }
    @Test
    public void testFindNonExistingDiscountById() {
        //mock:
        when(discountRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class,
                () -> discountService.getDiscountById(anyInt()));
        verify(discountRepository, times(1)).findById(anyInt());
    }

    //UPDATE------------------------------------------------------------------------------------------------------------

    @Test
    public void testUpdateExistingDiscount() {
        //prep:
        int discountId = 1;
        DiscountEntityModel existingData = new DiscountEntityModel(
                "123", "cus", BigDecimal.valueOf(100.00)
        );
        existingData.setDiscountId(discountId);
        //update data:
        DiscountEntityModel updateData = new DiscountEntityModel(
                "321", "adm", BigDecimal.valueOf(200.00)
        );
        updateData.setDiscountId(discountId);
        //mock:
        when(discountRepository.findById(discountId)).thenReturn(Optional.of(existingData));
        when(discountRepository.save(any(DiscountEntityModel.class))).thenReturn(updateData);
        //call the method form service:
        DiscountEntityModel result = discountService.updateDiscount(discountId, updateData);
        //assert and verify:
        assertEquals(updateData, result);
        verify(discountRepository, times(1)).findById(discountId);
        verify(discountRepository, times(1)).save(updateData);
    }

    @Test
    public void testUpdateNonExistingDiscount() {
        //mock:
        when(discountRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class,
                () -> discountService.updateDiscount(anyInt(), new DiscountEntityModel()));
    }

    //DELETE------------------------------------------------------------------------------------------------------------

    @Test
    public void testDeleteDiscount() {
        //prep:
        int discountId = 1;
        //call the method from service:
        discountService.deleteDiscountById(discountId);
        //verify that method is invoked once:
        verify(discountRepository, times(1)).deleteById(discountId);
    }
}
