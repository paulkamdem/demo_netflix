package com.mik_it.netflix.demo.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Movie {
    private String movieId;
    private String name;
}
