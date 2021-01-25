package data_art.tech_leaders_project.services;

import data_art.tech_leaders_project.entity.DirectorEntity;
import data_art.tech_leaders_project.entity.GenreEntity;
import data_art.tech_leaders_project.entity.MovieEntity;

import java.util.List;

public interface MovieService {
    List<MovieEntity> getMovies();

    MovieEntity getMovieByName(String name);

    List<MovieEntity> getAllMovieByYear(int year);

    List<MovieEntity> getAllMoviesByDirector(DirectorEntity directorEntity);

    List<MovieEntity> getAllMoviesByGenre(GenreEntity genreEntity);

    MovieEntity getMovieById(int id);

    void addMovie(String name, int year, int directorId, String country, List<Integer> genres);

    // void deleteMovieById (int id);
}
