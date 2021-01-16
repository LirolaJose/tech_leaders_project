package data_art.tech_leaders_project.controller;

import data_art.tech_leaders_project.dao.DirectorDAO;
import data_art.tech_leaders_project.dto.DirectorDTO;
import data_art.tech_leaders_project.dto.MovieDTO;
import data_art.tech_leaders_project.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    DirectorDAO directorDAO;

    public MovieController(MovieService service, DirectorDAO directorDAO) {
        this.movieService = service;
        this.directorDAO = directorDAO;
    }

    @RequestMapping("/allMovies")
    public List<MovieDTO> getMovies() {
        log.info("show all movies in localhost 8081");
        return movieService.getMovies();
    }

    @RequestMapping("/byName")
    public MovieDTO getMovieByName(@RequestParam String name) {
        log.info("show movie by name {} in localhost 8081", name);
        return movieService.getMovieByName(name);
    }

    @RequestMapping("/byYear")
    public List<MovieDTO> getAllMoviesByYear(@RequestParam int year) {
        log.info("show list of movies by year {} in localhost 8081", year);
        return movieService.getAllMovieByYear(year);
    }

    @RequestMapping("/byDirector")
    public List<MovieDTO> getAllMoviesByDirector(@RequestParam String name) {
        log.info("show list of movies by director {}", name);
        DirectorDTO directorDTO = directorDAO.findDirectorDTOByNameOrLast_name(name, name);
        return movieService.getAllMoviesByDirector(directorDTO);
    }
}
