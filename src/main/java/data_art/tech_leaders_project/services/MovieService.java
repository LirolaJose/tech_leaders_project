package data_art.tech_leaders_project.services;

import data_art.tech_leaders_project.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    List <MovieDTO> getMovies();
    MovieDTO findMovieByName (String name);
}
