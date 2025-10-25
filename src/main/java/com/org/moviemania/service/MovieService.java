package com.org.moviemania.service;


import com.org.moviemania.entity.Movie;
import com.org.moviemania.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public Mono<Movie> addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Flux<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Mono<Movie> getMovie(int id){
        return movieRepository.findById(id);
    }

    public Mono<Boolean> deleteMovie(int id){
        return movieRepository.deleteById(id).then(Mono.just(true));
    }
}
