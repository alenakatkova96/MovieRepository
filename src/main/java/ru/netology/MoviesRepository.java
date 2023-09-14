package ru.netology;

public class MoviesRepository {
    private MoviesItem[] movies = new MoviesItem[0];
    private int limit;

    public MoviesRepository() {
        this.limit = 5;
    }

    public MoviesRepository(int limit) {
        this.limit = limit;
    }

    public void addMovie(MoviesItem movie) {
        MoviesItem[] tmp = new MoviesItem[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public MoviesItem[] findAll() {
        return movies;
    }


    public MoviesItem[] findLast() {
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }

        MoviesItem[] tmp = new MoviesItem[resultLength];
        for (int i = 0; i < tmp.length; i++) {

            tmp[i] = movies[movies.length - 1 - i];
        }
        return tmp;
    }
}
