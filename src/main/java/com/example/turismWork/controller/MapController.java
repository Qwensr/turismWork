package com.example.turismWork.controller;


import com.example.turismWork.entities.Attraction;
import com.example.turismWork.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MapController {

    @Autowired
    private AttractionService attractionService;

    @GetMapping("/map")
    public String showMap(Model model) {
        List<Attraction> attractions = attractionService.findAll();
        model.addAttribute("attractions", attractions);
        return "map";
    }
}