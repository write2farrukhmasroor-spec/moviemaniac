package com.org.moviemania.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@Table("movie")
public class Movie {

    @Id
    private int id;
    @Column("movieName")
    private String movieName;
    @Column("movieDescription")
    private String movieDescription;
    private int rating;
}
