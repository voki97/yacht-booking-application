package com.example.yachtbookingapp.repository;

import com.example.yachtbookingapp.model.DiscountEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntityModel, Integer> {
    /**Custom method for retrieving discount entity by providing the code column.*/
    Optional<DiscountEntityModel> findDiscountByCode(String code);
}
