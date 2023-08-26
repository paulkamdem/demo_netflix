package com.mik_it.netflix.demo.controller;

import com.mik_it.netflix.demo.model.Movie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("movie_system")
@Api("test")
public interface MovieApi {
    //test api
    @GetMapping("/test_api")
    public String testApi();

    //create movie
    @PostMapping("/movie")
    @ApiResponses(value = {
            @ApiResponse(code= 201, message = "Movie created successfully"),
            @ApiResponse(code= 401, message = "Don't autorised to access to our system"),

    })
    public ResponseEntity<Movie> createMovie(@NonNull @RequestBody Movie movie);

    //delete movie
    @DeleteMapping("/movie/{movieId}")
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "Movie deleted successfully"),
            @ApiResponse(code= 401, message = "Don't autorised to access to our system"),

    })
    public ResponseEntity<Movie> deleteMovie(@NonNull @PathVariable String movieId);

    //get all movies
    @GetMapping("/movies")
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "Get all movies successfully"),
            @ApiResponse(code= 401, message = "Don't autorised to access to our system"),

    })
    public ResponseEntity<List<Movie>> getAllMovies();

    // update movie infos
    @PutMapping("/movie/{movieId}")
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "Movie updated successfully"),
            @ApiResponse(code= 401, message = "Don't autorised to access to our system"),

    })
    public ResponseEntity<Movie> updateMovie(@NonNull @PathVariable String movieId, @NonNull @RequestBody Movie movie);



}
