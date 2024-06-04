package com.example.turismWork.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ReviewDto {
    private Long id;
    private Long userId;
    private Long attractionId;
    private String comment;
    private int rating;
    private Date createdAt;
}
