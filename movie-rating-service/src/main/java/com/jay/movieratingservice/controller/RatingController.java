package com.jay.movieratingservice.controller;

import com.jay.movieratingservice.model.Rating;
import com.jay.movieratingservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movie-rating")
public class RatingController {

    @GetMapping("/mm")
    public String testing(){
        return "Service Called";
    }


//    @GetMapping("/{movieId}")
//    public Rating getMovieRating(@PathVariable String movieId){
//        return new Rating("cherry",4);
//    }
    @GetMapping("/user/{userId}")
    public UserRating getRating(@PathVariable String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("cherry",4),
                new Rating("starTrek",5));
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
