package com.example.turismWork.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttractionDto {
    private Long id;
    private String name;
    private String description;
    private String location;
    private double latitude;
    private double longitude;
}
