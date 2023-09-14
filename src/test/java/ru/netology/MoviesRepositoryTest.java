package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.MoviesRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MoviesRepositoryTest {
    MoviesRepository repo = Mockito.mock(MoviesRepository.class);

    MoviesItem movies1 = new MoviesItem(" Бладшот ", " Боевик ", LocalDate.of(2023, 12, 28));
    MoviesItem movies2 = new MoviesItem(" Вперед ", " Мультфильм ", LocalDate.of(2023, 7, 4));
    MoviesItem movies3 = new MoviesItem(" Отель Белград ", " Комедия ", LocalDate.of(2023, 2, 24));
    MoviesItem movies4 = new MoviesItem(" Джентельмены ", " Боевик ", LocalDate.of(2023, 8, 12));
    MoviesItem movies5 = new MoviesItem(" Человек невидимка ", " Ужасы ", LocalDate.of(2023, 10, 8));
    MoviesItem movies6 = new MoviesItem(" Тролли. Мировой Тур", " Мультики ", LocalDate.of(2023, 11, 11));
    MoviesItem movies7 = new MoviesItem(" Номер Один ", " Комедия ", LocalDate.of(2023, 7, 1));

    @Test
    public void getAll() {
        MoviesRepository repo = new MoviesRepository();

        repo.addMovie(movies1);
        repo.addMovie(movies2);
        repo.addMovie(movies3);
        repo.addMovie(movies4);
        repo.addMovie(movies5);
        repo.addMovie(movies6);
        repo.addMovie(movies7);

        MoviesItem[] expected = {movies1, movies2, movies3, movies4, movies5, movies6, movies7};
        MoviesItem[] actual = repo.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void getNull() {
        MoviesRepository repo = new MoviesRepository();

        MoviesItem[] actual = repo.findAll();
        MoviesItem[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getOne() {
        MoviesRepository repo = new MoviesRepository();

        repo.addMovie(movies7);

        MoviesItem[] expected = {movies7};
        MoviesItem[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getFive() {
        MoviesRepository repo = new MoviesRepository();

        repo.addMovie(movies7);
        repo.addMovie(movies3);
        repo.addMovie(movies2);
        repo.addMovie(movies6);
        repo.addMovie(movies1);


        MoviesItem[] expected = {movies7, movies3, movies2, movies6, movies1};
        MoviesItem[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastFiveMovie() {
        MoviesRepository repo = new MoviesRepository();
        repo.addMovie(movies1);
        repo.addMovie(movies2);
        repo.addMovie(movies3);
        repo.addMovie(movies4);
        repo.addMovie(movies5);
        repo.addMovie(movies6);
        repo.addMovie(movies7);

        repo.findLast();

        MoviesItem[] expected = {movies7, movies6, movies5, movies4, movies3};
        MoviesItem[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastTreeMovie() {
        MoviesRepository repo = new MoviesRepository(3);
        repo.addMovie(movies1);
        repo.addMovie(movies2);
        repo.addMovie(movies3);
        repo.addMovie(movies4);
        repo.addMovie(movies5);
        repo.addMovie(movies6);
        repo.addMovie(movies7);


        MoviesItem[] expected = {movies7, movies6, movies5};
        MoviesItem[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getNullMovie() {
        MoviesRepository repo = new MoviesRepository(0);
        repo.addMovie(movies1);
        repo.addMovie(movies2);
        repo.addMovie(movies3);
        repo.addMovie(movies4);
        repo.addMovie(movies5);
        repo.addMovie(movies6);
        repo.addMovie(movies7);


        MoviesItem[] expected = {};
        MoviesItem[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastAfterMax() {
        MoviesRepository repo = new MoviesRepository(8);

        repo.addMovie(movies1);
        repo.addMovie(movies2);
        repo.addMovie(movies3);
        repo.addMovie(movies4);
        repo.addMovie(movies5);
        repo.addMovie(movies6);
        repo.addMovie(movies7);


        MoviesItem[] expected = {movies7, movies6, movies5, movies4, movies3, movies2, movies1};
        MoviesItem[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void printMovies() {
        MoviesItem[] movies = {movies7, movies6, movies5, movies4, movies3, movies2, movies1};
        for (MoviesItem movie : movies) {
            System.out.println();
            System.out.println("Название Фильма: " + movie.getMovieName());
            System.out.println("Жанр Фильма: " + movie.getFilmGenre());
            System.out.println("Дата выхода: " + movie.getReleaseDate());
            System.out.println();
        }

    }

    @Test
    public void getAllWithMockito() {
        MoviesItem[] movies = {movies7, movies6, movies5, movies4, movies3, movies2, movies1};
        doReturn(movies).when(repo).findAll();

        MoviesItem[] expected = {movies7, movies6, movies5, movies4, movies3, movies2, movies1};
        MoviesItem[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}
