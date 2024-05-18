package com.example.yachtbookingapp.repository;

import com.example.yachtbookingapp.model.DiscountEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntityModel, Integer> {
}
