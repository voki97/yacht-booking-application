package com.example.yachtbookingapp.service;

import com.example.yachtbookingapp.model.YachtEntityModel;
import com.example.yachtbookingapp.repository.YachtRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class YachtServiceTest {
    private AutoCloseable closable;
    @Mock
    private YachtRepository yachtRepository;
    @InjectMocks
    private YachtService yachtService;

    @BeforeEach
    public void setUp() {
        closable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closable.close();
    }

    //TEST Basic CRUD methods:
    //CREATE------------------------------------------------------------------------------------------------------------
    @Test
    public void testCreateYacht() {
        //create a new object of type Yacht:
        YachtEntityModel testYacht = new YachtEntityModel(
                "Yacht Name", "Yacht type", BigDecimal.valueOf(100.00)
        );
        //mock:
        when(yachtRepository.save(any(YachtEntityModel.class))).thenReturn(testYacht);
        //call the service method:
        YachtEntityModel result = yachtService.createYacht(testYacht);
        //compare and assert:
        assertEquals(testYacht, result);
        //verify:
        verify(yachtRepository, times(1)).save(testYacht);
    }

    //READ--------------------------------------------------------------------------------------------------------------
    //all:
    @Test
    public void testReadAllYachts() {
        //several Yacht objects:
        YachtEntityModel testYacht1 = new YachtEntityModel(
                "Yacht Name", "Yacht type", BigDecimal.valueOf(100.00)
        );
        YachtEntityModel testYacht2 = new YachtEntityModel(
                "Yacht Name", "Yacht type", BigDecimal.valueOf(200.00)
        );
        YachtEntityModel testYacht3 = new YachtEntityModel(
                "Yacht Name", "Yacht type", BigDecimal.valueOf(300.00)
        );
        //List is a return type of the method, so these test Yachts have to be in Array List.
        List<YachtEntityModel> yachts = new ArrayList<>();
        yachts.add(testYacht1);
        yachts.add(testYacht2);
        yachts.add(testYacht3);
        //mock:
        when(yachtRepository.findAll()).thenReturn(yachts);
        //call the method:
        List<YachtEntityModel> returnedYachts = yachtService.getAllYachts();
        //then:
        //assert and verify:
        assertEquals(yachts, returnedYachts);
        verify(yachtRepository, times(1)).findAll();
    }

    //By ID:
    @Test
    public void testReadExistingYachtById() {
        YachtEntityModel testYacht = new YachtEntityModel(
                "Yacht Name", "Yacht type", BigDecimal.valueOf(100.00)
        );
        int yachtId = 1;
        //mock:
        when(yachtRepository.findById(yachtId)).thenReturn(Optional.of(testYacht));
        //call the method:
        YachtEntityModel result = yachtService.getYachtById(yachtId);
        //then:
        //assert and verify:
        assertEquals(testYacht, result);
        verify(yachtRepository, times(1)).findById(yachtId);
    }

    @Test
    public void testReadNonExistingYachtById() {
        int yachtId = 2;
        ///assert that exception is thrown when service class perform operation with non-existing ID:
        assertThrows(IllegalArgumentException.class, () -> yachtService.getYachtById(yachtId));
        //verify that findById is invoked once:
        verify(yachtRepository, times(1)).findById(yachtId);
    }

    //UPDATE------------------------------------------------------------------------------------------------------------
    @Test
    public void testUpdateExistingYacht() {
        //existing yacht ID:
        int existingYachtId = 1;
        //update data:
        YachtEntityModel testUpdateData = new YachtEntityModel(
                "Update Name", "Update type", BigDecimal.valueOf(200.00)
        );
        //Existing record:
        YachtEntityModel existingYacht = new YachtEntityModel(
                "Yacht Name", "Yacht type", BigDecimal.valueOf(100.00)
        );
        //mock existing record:
        when(yachtRepository.findById(existingYachtId)).thenReturn(Optional.of(existingYacht));
        //mock update record:
        when(yachtRepository.save(any(YachtEntityModel.class))).thenReturn(testUpdateData);
        //call the method:
        YachtEntityModel result = yachtService.updateYacht(existingYachtId, testUpdateData);
        //assert and verify that repository has found existing yacht and saved a successfully updated data object.
        assertEquals(testUpdateData, result);
        verify(yachtRepository, times(1)).findById(existingYachtId);
        verify(yachtRepository, times(1)).save(testUpdateData);
    }

    @Test
    public void testUpdateNonExistingYacht() {
        //non-existing yacht ID:
        int nonExistingYachtId = 10000;
        assertThrows(IllegalArgumentException.class, () -> yachtService.updateYacht(nonExistingYachtId, new YachtEntityModel()));
        verify(yachtRepository, times(1)).findById(nonExistingYachtId);
        verify(yachtRepository, never()).save(any(YachtEntityModel.class));
    }

    //DELETE------------------------------------------------------------------------------------------------------------

    @Test
    public void testDeleteYacht() {
        //Existing yacht ID:
        int yachtId = 1;
        //call the method:
        yachtService.deleteYacht(yachtId);
        //verify that method is invoked once:
        verify(yachtRepository, times(1)).deleteById(yachtId);
    }

    @Test
    public void testDeleteNonExistingYacht() {
        int nonExistingYachtId = 10000;
        yachtService.deleteYacht(nonExistingYachtId);
    }
}

