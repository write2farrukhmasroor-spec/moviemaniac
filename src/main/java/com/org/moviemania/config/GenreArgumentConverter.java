package com.org.moviemania.config;

import com.org.moviemania.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class GenreArgumentConverter implements org.springframework.core.convert.converter.Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        return Movie.Genre.valueOf(source).ordinal();
    }
}
