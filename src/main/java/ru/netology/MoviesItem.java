package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MoviesItem {
    private String MovieName;
    private String FilmGenre;
    private LocalDate ReleaseDate;

    public String getMovieName() {
        return MovieName;
    }

    public String getFilmGenre() {
        return FilmGenre;
    }

    public LocalDate getReleaseDate() {
        return ReleaseDate;
    }
}
