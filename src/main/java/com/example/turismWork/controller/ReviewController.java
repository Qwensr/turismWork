package com.example.turismWork.controller;

import com.example.turismWork.entities.Attraction;
import com.example.turismWork.entities.Review;
import com.example.turismWork.entities.User;
import com.example.turismWork.service.ReviewService;
import com.example.turismWork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @GetMapping("/attraction/{id}/reviews")
    public String showReviews(@PathVariable Long id, Model model) {
        List<Review> reviews = reviewService.findByAttractionId(id);
        model.addAttribute("reviews", reviews);
        return "reviews";
    }

    @PostMapping("/attraction/{id}/reviews")
    public String addReview(@PathVariable Long id, @RequestParam String comment, @RequestParam int rating, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Review review = new Review();
        review.setAttraction(new Attraction(id));
        review.setUser(user);
        review.setComment(comment);
        review.setRating(rating);
        review.setCreatedAt(new Date());
        reviewService.save(review);
        return "redirect:/attraction/" + id + "/reviews";
    }
}
