package data_art.tech_leaders_project.controller.admin;

import data_art.tech_leaders_project.dao.DirectorRepository;
import data_art.tech_leaders_project.dao.GenreRepository;
import data_art.tech_leaders_project.dao.MovieRepository;
import data_art.tech_leaders_project.dto.MovieEntity;
import data_art.tech_leaders_project.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Admin")
@Slf4j
public class AdminController {
    final MovieRepository movieRepository;
    final MovieService movieService;
    final DirectorRepository directorRepository;
    final GenreRepository genreRepository;


    public AdminController(MovieRepository movieRepository, MovieService movieService, DirectorRepository directorRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
    }

    @RequestMapping("/deleteMovie")
    String deleteMovieById(@RequestParam int id) {
        String movieName = movieRepository.findMovieEntityById(id).getName();
        MovieEntity movieEntity = movieRepository.findMovieEntityById(id);
        movieRepository.delete(movieEntity);
        log.info("movie {} is removed", movieName);
        return "Movie " + movieName + " is removed";
    }

    @RequestMapping("/addMovie") // why I used the @RequestMapping instead @Post
    String addMovie(@RequestParam String name, @RequestParam int year, @RequestParam int directorID, @RequestParam String country, @RequestParam int... genres) {
        movieService.addMovie(name, year, directorID, country, genres);
        log.info("new movie is added: {}", name);
        return "New movie is added: " + name;
    }
}
