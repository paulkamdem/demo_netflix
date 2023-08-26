package com.mik_it.netflix.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "Movie")
@Data
public class MovieEntity {
    @Id
    @GeneratedValue
    private long id;
    private String movieId;
    private String name;
}
