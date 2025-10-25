package com.org.moviemania.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cast {
    private List<String> actors;
    private List<String> actress;

    private List<String> directors;
    private String producer;
}
