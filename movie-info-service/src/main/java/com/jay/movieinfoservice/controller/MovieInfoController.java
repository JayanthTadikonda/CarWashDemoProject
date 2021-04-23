package com.jay.movieinfoservice.controller;

import com.jay.movieinfoservice.model.MovieInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-info")
public class MovieInfoController {

    @GetMapping("/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable String movieId){
        return new MovieInfo(movieId,"Test - part1");
    }
}
