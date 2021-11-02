package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode

public class Movies {
    private int id;
    private String name;
    private int genre;
    private boolean premiere;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGenre() {
        return genre;
    }

    public boolean isPremiere() {
        return premiere;
    }
}
