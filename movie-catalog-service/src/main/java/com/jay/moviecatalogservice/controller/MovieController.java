package com.jay.moviecatalogservice.controller;

import com.jay.moviecatalogservice.model.Movie;
import com.jay.moviecatalogservice.model.MovieInfo;
import com.jay.moviecatalogservice.model.Rating;
import com.jay.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie-catalog")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/m")
    public String getRating(){
        String str = restTemplate.getForObject("http://movie-rating-service/movie-rating/mm",String.class);
        return str;
    }

    @GetMapping("/{userid}")
    @LoadBalanced
    public List<Movie> getAllMovies(@PathVariable String userid){

        UserRating ratings = restTemplate.getForObject("http://movie-rating-service/user/"+userid, UserRating.class);

        assert ratings != null;
        return ratings.getUserRating().stream().map(rating->{
            //for each movie id, call movie info service and get the details
          MovieInfo movieInfo = restTemplate.getForObject("http://localhost:8082/movie-info/"+ rating.getId(), MovieInfo.class);
           //Get them all together and return
            return new Movie(movieInfo.getMovieName(), "part1", rating.getRating());
        })
        .collect(Collectors.toList());
    }
}
