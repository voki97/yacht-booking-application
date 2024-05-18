package com.example.yachtbookingapp.repository;

import com.example.yachtbookingapp.model.YachtEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YachtRepository extends JpaRepository<YachtEntityModel, Integer> {
}
