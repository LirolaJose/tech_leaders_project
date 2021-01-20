package data_art.tech_leaders_project.controller;

import data_art.tech_leaders_project.dao.DirectorRepository;
import data_art.tech_leaders_project.dto.DirectorEntity;
import data_art.tech_leaders_project.dto.MovieEntity;
import data_art.tech_leaders_project.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Movies")
@Slf4j
public class MovieController {

    final
    MovieService movieService;
    final
    DirectorRepository directorRepository;

    public MovieController(MovieService service, DirectorRepository directorRepository) {
        this.movieService = service;
        this.directorRepository = directorRepository;
    }

    @RequestMapping("/allMovies")
    public List<MovieEntity> getMovies() {
        log.info("show all movies in the localhost 8081");
        return movieService.getMovies();
    }

    @RequestMapping("/byName")
    public MovieEntity getMovieByName(@RequestParam String name) {
        log.info("show movie by name {} in the localhost 8081", name);
        return movieService.getMovieByName(name);
    }

    @RequestMapping("/byYear")
    public List<MovieEntity> getAllMoviesByYear(@RequestParam int year) {
        log.info("show list of movies by year {} in the localhost 8081", year);
        return movieService.getAllMovieByYear(year);
    }

    @RequestMapping("/byDirector")
    public List<MovieEntity> getAllMoviesByDirector(@RequestParam String name) {
        log.info("show list of movies by director {} in the localhost8081", name);
        DirectorEntity directorEntity = directorRepository.findDirectorEntityByNameOrLast_name(name, name);
        return movieService.getAllMoviesByDirector(directorEntity);
    }
}
