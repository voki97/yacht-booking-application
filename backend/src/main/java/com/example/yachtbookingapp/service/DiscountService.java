package com.example.yachtbookingapp.service;

import com.example.yachtbookingapp.model.DiscountEntityModel;
import com.example.yachtbookingapp.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The DiscountService class<br>
 * provides methods for CRUD
 * ({@link #createDiscount Create},
 * {@link #getAllDiscounts Read},
 * {@link #updateDiscount Update},
 * {@link #deleteDiscountById Delete})
 * operations related to discount entities. It serves as a service layer component in the application.
 */
@Service
@RequiredArgsConstructor
public class DiscountService {
    //Attributes:
    private final DiscountRepository discountRepository;

    //Basic CRUD operations:
    //CREATE------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new discount entity in the database.
     *
     * @param #discountEntityModel The discount entity to be created.
     * @return DiscountEntityModel - the created discount entity.
     */
    public DiscountEntityModel createDiscount(DiscountEntityModel discountEntityModel) {
        return discountRepository.save(discountEntityModel);
    }

    //READ--------------------------------------------------------------------------------------------------------------
    //all:

    /**
     * Retrieves a list of all discount entities from the database.
     *
     * @return A list of all discount entities. Returns an empty list if no discounts are found.
     */
    public List<DiscountEntityModel> getAllDiscounts() {
        return discountRepository.findAll();
    }

    //specific by ID:

    /**
     * Retrieves a specific discount entity from the database by its ID.
     *
     * @param discountId The ID of the discount entity to retrieve.
     * @return DiscountEntityModel - the discount entity with the specified ID.
     * @throws IllegalArgumentException If no discount entity is found with the specified ID.
     */
    public DiscountEntityModel getDiscountById(int discountId) {
        return discountRepository.findById(discountId).orElseThrow(() ->
                new IllegalArgumentException("Discount with ID: " + discountId + " not found!"));
    }

    //specific by CODE:

    /**
     * Retrieves a specific discount entity from the database by its unique code.
     *
     * @param discountCode provided code input that
     * @return optional DiscountEntityModel if one exists in the database,
     * else
     * @throws IllegalArgumentException if no discount entity is found.*/
    public DiscountEntityModel getDiscountByCode(String discountCode) {
        return discountRepository.findDiscountByCode(discountCode).orElseThrow(()->
                new IllegalArgumentException("Discount with code: " + discountCode + " not found!"));
    }
    //UPDATE------------------------------------------------------------------------------------------------------------

    /**
     * Updates an existing discount entity in the database.
     *
     * @param discountId         The ID of the discount entity to update.
     * @param discountUpdateData The updated data for the discount entity.
     * @return DiscountEntityModel - the updated discount entity.
     * @throws IllegalArgumentException If no discount entity is found with the specified ID.
     */
    public DiscountEntityModel updateDiscount(int discountId, DiscountEntityModel discountUpdateData) {
        DiscountEntityModel existingDiscount = discountRepository.findById(discountId).orElseThrow(() ->
                new IllegalArgumentException("Discount with ID: " + discountId + " not found!"));
        existingDiscount.setCode(discountUpdateData.getCode());
        existingDiscount.setType(discountUpdateData.getType());
        existingDiscount.setValue(discountUpdateData.getValue());
        return discountRepository.save(existingDiscount);
    }

    //DELETE------------------------------------------------------------------------------------------------------------

    /**
     * Deletes a discount entity from the database by its ID.
     *
     * @param discountId The ID of the discount entity to delete.
     */
    public void deleteDiscountById(int discountId) {
        discountRepository.deleteById(discountId);
    }
}
