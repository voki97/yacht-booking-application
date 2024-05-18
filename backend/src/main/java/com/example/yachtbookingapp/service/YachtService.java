package com.example.yachtbookingapp.service;

import com.example.yachtbookingapp.model.YachtEntityModel;
import com.example.yachtbookingapp.repository.YachtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**Provides methods for CRUD:<br>
 *({@link #createYacht Create},
 * {@link #getAllYachts Read},
 * {@link #updateYacht Update},
 * {@link #deleteYacht Delete})<br>
 * operations related to yacht entities.
 * It serves as a service layer component in the application.*/
@Service
@RequiredArgsConstructor
public class YachtService {
    //Attributes:
    private final YachtRepository yachtRepo;

    //Basic CRUD method:
    //CREATE---------------------------------------------------------------------------
    /**Create a new yacht in the database.
     * @param yacht Yacht entity to be created and saved in the database.
     * @return YachtEntityModel - The created yacht entity.*/
    public YachtEntityModel createYacht(YachtEntityModel yacht) {
        return yachtRepo.save(yacht);
    }

    //READ------------------------------------------------------------------------------
    //all:
    /**Retrieve a list of all yacht entities from the database.
     * @return a list of yacht entities.<br>*/
    public List<YachtEntityModel> getAllYachts() {
        return yachtRepo.findAll();
    }

    //specific by ID:
    /**Retrieves a specific yacht entity from the database by its ID.
     * @param id The ID of the yacht entity ot retrieve.
     * @return YachtEntityModel The yacht entity with the specified ID.
     * @throws IllegalArgumentException if no yacht entity is found with the specified ID.*/
    public YachtEntityModel getYachtById(int id) {
        return yachtRepo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Yacht with id " + id + " not found!"));
    }

    //UPDATE-----------------------------------------------------------------------------
    /**Updates an existing yacht entity in the database.
     * @param yachtId The ID of the yacht entity to update.
     * @param yachtUpdateData  The updated data for the yacht entity.
     * @return The updated yacht entity.
     * @throws IllegalArgumentException If no yacht entity is found with the specified ID.*/
    public YachtEntityModel updateYacht(int yachtId, YachtEntityModel yachtUpdateData) {
        YachtEntityModel existingYacht = yachtRepo.findById(yachtId).orElseThrow(()->
                new IllegalArgumentException("Yacht with yachtId " + yachtId + " not found!"));
        existingYacht.setName(yachtUpdateData.getName());
        existingYacht.setType(yachtUpdateData.getType());
        existingYacht.setPricePerDay(yachtUpdateData.getPricePerDay());
        return yachtRepo.save(existingYacht);
    }
    //DELETE------------------------------------------------------------------------------
    /**Deletes a yacht entity from the database by its ID.
     * @param id The ID of the yacht entity to delete.*/
    public void deleteYacht(int id) {
        yachtRepo.deleteById(id);
    }
}