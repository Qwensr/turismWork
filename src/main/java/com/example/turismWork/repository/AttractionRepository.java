package com.example.turismWork.repository;

import com.example.turismWork.entities.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
}