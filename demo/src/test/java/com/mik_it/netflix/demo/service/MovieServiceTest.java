package com.mik_it.netflix.demo.service;
import com.mik_it.netflix.demo.entity.MovieEntity;
import com.mik_it.netflix.demo.exception.BadRequestMovieException;
import com.mik_it.netflix.demo.exception.NotFoundMovieException;
import com.mik_it.netflix.demo.model.Movie;
import com.mik_it.netflix.demo.repository.MovieRepository;
import com.mik_it.netflix.demo.utils.MovieMapper;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.*;
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceTest {
    @InjectMocks
    private MovieService service;

    @Mock
    private MovieRepository repository;

    @Test
    public void testCreateMovie() {
        //create some fake movie
        // should call the method createMovie
        // check if save method from db is called 1 time

        Movie movie = new Movie();
        movie.setMovieId("1");
        movie.setName("test name");
        service.createMovie(movie);
        verify(repository, times(1)).save(any());
    }

    @Test
    public void testDeleteMovie(){
        // save the movie with this id in db
        // now , call deleteMovie()
        // check if delete method from repository is called 1 time


        Movie movie = new Movie();
        movie.setMovieId("movieId");
        movie.setName("test name");

        when(repository.findByMovieId("movieId")).thenReturn(MovieMapper.INSTANCE.mapModelToEntity(movie));

        service.deleteMovie("movieId");
        verify(repository, times(1)).delete(any());
    }

    @Test(expected = NotFoundMovieException.class)
    public void testDeleteMovieWithNotFoundMovieException() {
        service.deleteMovie("fakemovieId");
    }

    @Test
    public void testGetAllMovies(){
        // save 2 movies in db
        // now , call getAllMovies()
        // check if the number of movies is 2


        Movie movie = new Movie();
        movie.setMovieId("movieId");
        movie.setName("test name");
        List<MovieEntity> list = new ArrayList<>();
        list.add(MovieMapper.INSTANCE.mapModelToEntity(movie));
        list.add(MovieMapper.INSTANCE.mapModelToEntity(movie));

        when(repository.findAll()).thenReturn(list);

        List<Movie> response = service.getAllMovies();

        MatcherAssert.assertThat(response.size(), is(2));
    }

    @Test(expected = BadRequestMovieException.class)
    public void testUpdateMovieWithBadRequestMovieException(){
        // insert movie with movie id : test
        // call the method with bad movieid
        Movie movie = new Movie();
        movie.setMovieId("movieId");
        movie.setName("test");
        service.updateMovie("wrongMovieId", movie);

    }

    @Test(expected = NotFoundMovieException.class)
    public void testUpdateMovieWithNotFoundMovieException(){
        // insert movie with movie id : test
        // call the method with bad movieid
        Movie movie = new Movie();
        movie.setMovieId("movieId");
        movie.setName("test");

        when(repository.findByMovieId("movieId")).thenReturn(null);
        service.updateMovie("movieId", movie);
    }

    @Test
    public void testUpdateMovie(){
        // insert movie with movie id : test
        // call the method with bad movieid
        Movie movie = new Movie();
        movie.setMovieId("movieId");
        movie.setName("test");

        when(repository.findByMovieId("movieId")).thenReturn(MovieMapper.INSTANCE.mapModelToEntity(movie));

        Movie newMovie = movie;
        newMovie.setName("Casa del Papel");
        service.updateMovie("movieId", newMovie);

        verify(repository, times(1)).save(any());
    }





}
