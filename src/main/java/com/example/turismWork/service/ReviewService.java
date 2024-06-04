package com.example.turismWork.service;

import com.example.turismWork.entities.Review;
import com.example.turismWork.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findByAttractionId(Long attractionId) {
        return reviewRepository.findByAttractionId(attractionId);
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }
}