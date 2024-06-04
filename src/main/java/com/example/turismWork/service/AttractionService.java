package com.example.turismWork.service;

import com.example.turismWork.entities.Attraction;

import java.util.List;

import com.example.turismWork.entities.Attraction;
import com.example.turismWork.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionService {

    @Autowired
    private AttractionRepository attractionRepository;

    public List<Attraction> findAll() {
        return attractionRepository.findAll();
    }

    public Attraction save(Attraction attraction) {
        return attractionRepository.save(attraction);
    }
}
