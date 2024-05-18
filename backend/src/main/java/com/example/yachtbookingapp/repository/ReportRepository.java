package com.example.yachtbookingapp.repository;

import com.example.yachtbookingapp.model.ReportEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntityModel, Integer> {
}
