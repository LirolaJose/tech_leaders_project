package data_art.tech_leaders_project.services;

import data_art.tech_leaders_project.dto.DirectorEntity;
import data_art.tech_leaders_project.dto.GenreEntity;
import data_art.tech_leaders_project.dto.MovieEntity;

import java.util.List;

public interface MovieService {
    List<MovieEntity> getMovies();

    MovieEntity getMovieByName(String name);

    List<MovieEntity> getAllMovieByYear(int year);

    List<MovieEntity> getAllMoviesByDirector(DirectorEntity directorEntity);

    List<MovieEntity> getAllMoviesByGenre(GenreEntity genreEntity);

    MovieEntity getMovieById(int id);

    void addMovie(String name, int year, int director_id, String country, int...genres);

    // void deleteMovieById (int id);
}
