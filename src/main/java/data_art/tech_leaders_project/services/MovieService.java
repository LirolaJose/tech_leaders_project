package data_art.tech_leaders_project.services;

import data_art.tech_leaders_project.dto.DirectorDTO;
import data_art.tech_leaders_project.dto.GenreDTO;
import data_art.tech_leaders_project.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    List<MovieDTO> getMovies();

    MovieDTO getMovieByName(String name);

    List<MovieDTO> getAllMovieByYear(int year);

    List<MovieDTO> getAllMoviesByDirector(DirectorDTO directorDTO);

    List<MovieDTO> getAllMoviesByGenre(GenreDTO genreDTO);

    MovieDTO getMovieById(int id);

//    void addMovie(String name, int year, int director_id, String country);

   // void deleteMovieById (int id);
}
