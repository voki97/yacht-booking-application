package com.example.yachtbookingapp.controller;

import com.example.yachtbookingapp.model.YachtEntityModel;
import com.example.yachtbookingapp.service.YachtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The YachtController class <br>
 * is responsible for handling HTTP requests related to yacht operations such as: <br>
 * {@link #createYacht creating},
 * {@link #getAllYacht reading},
 * {@link #updateYacht updating}, and
 * {@link #deleteYacht deleting} yacht records.<br> It serves as a REST controller in the application.
 */
@RestController
@RequestMapping("/api/yacht")
@CrossOrigin
@RequiredArgsConstructor
public class YachtController {
    private final YachtService yachtService;

    //ENDPOINTS:
    //CREATE------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new yacht record in the database.
     */
    @PostMapping("/create")
    public ResponseEntity<YachtEntityModel> createYacht(@RequestBody YachtEntityModel yachtEntityModel) {
        //call method from service:
        YachtEntityModel yacht = yachtService.createYacht(yachtEntityModel);
        return ResponseEntity.ok(yacht);
    }

    //READ--------------------------------------------------------------------------------------------------------------
    //All records:

    /**
     * Retrieves all yacht records from the database.
     */
    @GetMapping("/all")
    public ResponseEntity<List<YachtEntityModel>> getAllYacht() {
        //call the method from service:
        List<YachtEntityModel> yachts = yachtService.getAllYachts();
        return ResponseEntity.ok(yachts);
    }

    //Find yacht by ID:

    /**
     * Retrieves specific yacht record by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<YachtEntityModel> getYachtById(@PathVariable("id") int id) {
        YachtEntityModel yacht = yachtService.getYachtById(id);
        return ResponseEntity.ok(yacht);
    }

    //UPDATE------------------------------------------------------------------------------------------------------------

    /**
     * Updates an existing yacht record.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<YachtEntityModel> updateYacht(@PathVariable("id") int id,
                                                        @RequestBody YachtEntityModel updateData) {
        YachtEntityModel yacht = yachtService.updateYacht(id, updateData);
        return ResponseEntity.ok(yacht);
    }

    //DELETE------------------------------------------------------------------------------------------------------------

    /**
     * Deletes a yacht record from the database.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteYacht(@PathVariable("id") int id) {
        yachtService.deleteYacht(id);
        return ResponseEntity.noContent().build();
    }
}
