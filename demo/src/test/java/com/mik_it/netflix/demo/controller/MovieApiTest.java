package com.mik_it.netflix.demo.controller;

import com.mik_it.netflix.demo.model.Movie;
import com.mik_it.netflix.demo.service.MovieService;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.*;

@WebMvcTest(MovieApiImpl.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieApiTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private MovieService service;

    @Test
    public void testTestApi() throws Exception {
        //giv some link or api request: /movie_system/test_api
        //make a get request : Get
        // 200 from server as response
        MockHttpServletResponse response =  mockMvc.perform(
                MockMvcRequestBuilders.get("/movie_system/test_api")).andReturn().getResponse();
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }

    @Test
    public void testCreateMovie() throws Exception {
        //giv some link or api request: /movie_system/movie
        //make a post request : post
        // 201 from server as response
        Movie movie = new Movie();
        movie.setMovieId("1");
        movie.setName("casa del papel");
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(movie);
        MockHttpServletResponse response =  mockMvc.perform(
                MockMvcRequestBuilders.post("/movie_system/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andReturn().getResponse();
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.CREATED.value()));

    }

    @Test
    public void testDeleteMovie() throws Exception {
        //giv some link or api request: /movie_system/movie
        //make a delete request : delete
        // 200 from server as response
        MockHttpServletResponse response =  mockMvc.perform(
                MockMvcRequestBuilders.delete("/movie_system/movie/movieId")
        ).andReturn().getResponse();
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));

    }

    @Test
    public void testGetAllMovies() throws Exception {
        //giv some link or api request: /movie_system/movies
        //make a get request : get
        // 200 from server as response
        MockHttpServletResponse response =  mockMvc.perform(
                MockMvcRequestBuilders.get("/movie_system/movies")
        ).andReturn().getResponse();
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));

    }

    @Test
    public void testUpdateMovie() throws Exception {
        //giv some link or api request: /movie_system/movie/1
        //make a put request : put
        // 200 from server as response
        Movie movie = new Movie();
        movie.setMovieId("1");
        movie.setName("casa del papellll");
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(movie);
        MockHttpServletResponse response =  mockMvc.perform(
                MockMvcRequestBuilders.put("/movie_system/movie/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andReturn().getResponse();
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));

    }


}
