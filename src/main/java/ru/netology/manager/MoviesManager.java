package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Movies;

@NoArgsConstructor
public class MoviesManager {

    private Movies[] movies = new Movies[0];
    private int numberOfFilms = 10;


    public MoviesManager(int numberOfFilms) {
        this.numberOfFilms = numberOfFilms;
    }


    public void add(Movies movie) {
        int length = movies.length + 1;
        Movies[] tmp = new Movies[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

        public Movies[] getAll() {
        int resultLength;
        if (movies.length > numberOfFilms) {
            resultLength = numberOfFilms;
        }
        else {
            resultLength = movies.length;
        }
            Movies[] result = new Movies[resultLength];
            for (int i = 0; i < resultLength; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
            return result;
        }
}
