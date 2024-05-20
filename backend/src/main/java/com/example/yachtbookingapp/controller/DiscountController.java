package com.example.yachtbookingapp.controller;

import com.example.yachtbookingapp.model.DiscountEntityModel;
import com.example.yachtbookingapp.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The DiscountController class<br>
 * is responsible for handling HTTP requests related to discount operations such as:<br>
 * {@link #createDiscount creating},
 * {@link #getAllDiscount reading},
 * {@link #updateDiscount updating}, and
 * {@link #deleteDiscount deleting} discount records.
 * It serves as a REST controller in the application.
 */
@RestController
@RequestMapping("/api/discount")
@CrossOrigin
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService discountService;

    //ENDPOINTS:
    //CREATE------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new discount record.
     */
    @PostMapping("/create")
    public ResponseEntity<DiscountEntityModel> createDiscount(@RequestBody DiscountEntityModel discountEntityModel) {
        DiscountEntityModel createDiscount = discountService.createDiscount(discountEntityModel);
        return ResponseEntity.ok(createDiscount);
    }

    //READ--------------------------------------------------------------------------------------------------------------
    //All records:

    /**
     * Retrieves all discount records.
     */
    @GetMapping("/all")
    public ResponseEntity<List<DiscountEntityModel>> getAllDiscount() {
        List<DiscountEntityModel> discounts = discountService.getAllDiscounts();
        return ResponseEntity.ok(discounts);
    }

    //By ID:

    /**
     * Retrieves a specific discount record by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DiscountEntityModel> getDiscountById(@PathVariable("id") int id) {
        DiscountEntityModel discount = discountService.getDiscountById(id);
        return ResponseEntity.ok(discount);
    }

    //UPDATE------------------------------------------------------------------------------------------------------------

    /**
     * Updates an existing discount record.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<DiscountEntityModel> updateDiscount(@PathVariable("id") int id, @RequestBody DiscountEntityModel updateData) {
        DiscountEntityModel discount = discountService.updateDiscount(id, updateData);
        return ResponseEntity.ok(discount);
    }

    //DELETE------------------------------------------------------------------------------------------------------------

    /**
     * Deletes a discount record.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DiscountEntityModel> deleteDiscount(@PathVariable("id") int id) {
        discountService.deleteDiscountById(id);
        return ResponseEntity.noContent().build();
    }
}
