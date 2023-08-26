package com.mik_it.netflix.demo.utils;

import com.mik_it.netflix.demo.entity.MovieEntity;
import com.mik_it.netflix.demo.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    // Movie --> MovieEntity
    MovieEntity mapModelToEntity(Movie movie);
    // MovieEntity --> Movie
    Movie mapEntityToModel(MovieEntity entity);
}
