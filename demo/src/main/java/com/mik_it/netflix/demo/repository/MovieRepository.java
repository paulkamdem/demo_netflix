package com.mik_it.netflix.demo.repository;

import com.mik_it.netflix.demo.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieEntity, Long> {
    // save movie : save()
    // get movie: findByMovieId
    MovieEntity findByMovieId(String movieId);
}
