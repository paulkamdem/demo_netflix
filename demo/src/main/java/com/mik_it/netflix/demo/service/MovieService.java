package com.mik_it.netflix.demo.service;

import com.mik_it.netflix.demo.entity.MovieEntity;
import com.mik_it.netflix.demo.exception.BadRequestMovieException;
import com.mik_it.netflix.demo.exception.NotFoundMovieException;
import com.mik_it.netflix.demo.model.Movie;
import com.mik_it.netflix.demo.repository.MovieRepository;
import com.mik_it.netflix.demo.utils.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie createMovie(Movie movie) {

        // set the unique id . 9824943-3245983945-43535
        // transform this in movieentity
        // save in db
        movie.setMovieId(UUID.randomUUID().toString());
        MovieEntity entity = MovieMapper.INSTANCE.mapModelToEntity(movie);

        movieRepository.save(entity);

        return movie;
    }


    public Movie deleteMovie(String movieId) {

        // check if movieId exist in db
        // if false, then send exception with NotFoundException 404 as server response
        // if true, then delete in db

        MovieEntity entity = movieRepository.findByMovieId(movieId);
        if(entity == null){
            throw new NotFoundMovieException("Movie id doest not exist in db");
        }
        movieRepository.delete(entity);
        return MovieMapper.INSTANCE.mapEntityToModel(entity);
    }
    public List<Movie> getAllMovies() {
        //should call the findAll from repository
        List<Movie> movies = new ArrayList<>();
        for (MovieEntity entity: movieRepository.findAll())
        {
            movies.add(MovieMapper.INSTANCE.mapEntityToModel(entity));
        }
        return movies;
    }
    public Movie updateMovie(String movieId, Movie movie) {


        // check if movieId is the same with movieId from movie
        // if not , then BadRequestMovieException with 400 as response server


        // check if movieId exist in db
        // if not, then NotFoundException

        // call save method from repository

        if (! movieId.equals(movie.getMovieId())){
            throw new BadRequestMovieException("Movie Id is not the same with your movie you want to update");
        }
        MovieEntity entity = movieRepository.findByMovieId(movieId);
        if(entity == null){
            throw new NotFoundMovieException("movieId doest not exist in db");
        }

        entity.setMovieId(movieId);
        entity.setName(movie.getName());
        movieRepository.save(entity);
        return movie;
    }

}
