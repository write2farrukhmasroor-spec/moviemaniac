package com.org.moviemania.repository;

import com.org.moviemania.entity.Movie;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends ReactiveCrudRepository<Movie,Integer> {
}
