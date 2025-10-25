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

    @Column("movieCast")
    private Cast movieCast;

    @Column("genre")
    private Genre genre;  // enum instead of Integer

    public enum Genre{
        SUSPENSE(0),
        HORROR (1),
        COMEDY(2),
        ACTION(3),
        DRAMA(4),
        BIOGRAPHY(5);

        Genre(int i) {
        }

        public static Genre fromInt(int i){
            return values()[i];
        }
        public int toIntValue(){
            return this.ordinal();
        }
    }
}
