package com.example.yachtbookingapp.repository;

import com.example.yachtbookingapp.model.BookingEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntityModel, Integer> {
}
