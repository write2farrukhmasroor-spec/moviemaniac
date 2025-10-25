package com.org.moviemania.controller;

import com.org.moviemania.entity.Movie;
import com.org.moviemania.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @QueryMapping
    public Flux<Movie> allMovies(){
        return movieService.getAllMovies();
    }

    @QueryMapping
    public Mono<Movie> movieById(@Argument int id){
        return movieService.getMovie(id);
    }

    @MutationMapping
    public Mono<Movie> addMovie(@Argument("movie") Movie movie){
        return movieService.addMovie(movie);
    }

    @MutationMapping
    public Mono<Boolean> deleteMovie(@Argument int id){
        return movieService.deleteMovie(id);
    }
}
