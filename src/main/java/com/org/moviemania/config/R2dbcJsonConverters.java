package com.org.moviemania.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.moviemania.entity.Cast;
import com.org.moviemania.entity.Movie;
import io.r2dbc.postgresql.codec.Json;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.DialectResolver;
import org.springframework.data.r2dbc.dialect.R2dbcDialect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class R2dbcJsonConverters {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public R2dbcCustomConversions r2dbcCustomConversions(ConnectionFactory connectionFactory) {
        R2dbcDialect dialect = DialectResolver.getDialect(connectionFactory);

        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new JsonToCastConverter());
        converters.add(new CastToJsonConverter());
        converters.add(new IntegerToGenreConverter());
        converters.add(new GenreToIntegerConverter());
        return R2dbcCustomConversions.of(dialect, converters);
    }

    @ReadingConverter
    class JsonToCastConverter implements Converter<Json, Cast> {
        @Override
        public Cast convert(Json source) {
            try {
                return objectMapper.readValue(source.asString(), Cast.class);
            } catch (IOException e) {
                throw new RuntimeException("Failed to convert JSON to Cast", e);
            }
        }
    }

    @WritingConverter
    class CastToJsonConverter implements Converter<Cast, Json> {
        @Override
        public Json convert(Cast source) {
            try {
                return Json.of(objectMapper.writeValueAsString(source));
            } catch (IOException e) {
                throw new RuntimeException("Failed to convert Cast to JSON", e);
            }
        }
    }

    @ReadingConverter
    static class IntegerToGenreConverter implements Converter<Integer, Movie.Genre> {
        @Override
        public Movie.Genre convert(Integer source) { return Movie.Genre.values()[source]; }
    }

    @WritingConverter
    static class GenreToIntegerConverter implements Converter<Movie.Genre, Integer> {
        @Override
        public Integer convert(Movie.Genre source) { return source.ordinal(); }
    }
}

