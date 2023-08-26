package com.mik_it.netflix.demo.controller;

import com.mik_it.netflix.demo.model.Movie;
import com.mik_it.netflix.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class MovieApiImpl implements MovieApi{

    private final MovieService service;
    @Override
    public String testApi() {
        return "Api works very well";
    }

    @Override
    public ResponseEntity<Movie> createMovie(Movie movie) {
        return new ResponseEntity<>(service.createMovie(movie), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Movie> deleteMovie(String movieId) {
        return new ResponseEntity<>(service.deleteMovie(movieId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(service.getAllMovies(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Movie> updateMovie(String movieId, Movie movie) {
        return new ResponseEntity<>(service.updateMovie(movieId, movie), HttpStatus.OK);
    }
}
