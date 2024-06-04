package com.example.turismWork.controller;

import com.example.turismWork.entities.Attraction;
import com.example.turismWork.model.AttractionDto;
import com.example.turismWork.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/attractions")
public class AttractionController {

    @Autowired
    private AttractionService attractionService;

    @GetMapping
    public List<AttractionDto> getAllAttractions() {
        return attractionService.findAll().stream()
                .map(attraction -> {
                    AttractionDto dto = new AttractionDto();
                    dto.setId(attraction.getId());
                    dto.setName(attraction.getName());
                    dto.setDescription(attraction.getDescription());
                    dto.setLocation(attraction.getLocation());
                    dto.setLatitude(attraction.getLatitude());
                    dto.setLongitude(attraction.getLongitude());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @PostMapping
    public AttractionDto addAttraction(@RequestBody AttractionDto attractionDTO) {
        Attraction attraction = new Attraction();
        attraction.setName(attractionDTO.getName());
        attraction.setDescription(attractionDTO.getDescription());
        attraction.setLocation(attractionDTO.getLocation());
        attraction.setLatitude(attractionDTO.getLatitude());
        attraction.setLongitude(attractionDTO.getLongitude());
        attraction = attractionService.save(attraction);
        attractionDTO.setId(attraction.getId());
        return attractionDTO;
    }
}