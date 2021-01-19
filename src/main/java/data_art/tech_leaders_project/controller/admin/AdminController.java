package data_art.tech_leaders_project.controller.admin;

import data_art.tech_leaders_project.dao.MovieDAO;
import data_art.tech_leaders_project.dto.MovieDTO;
import data_art.tech_leaders_project.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Admin")
@Slf4j
public class AdminController {
    final
    MovieDAO movieDAO;
    final MovieService movieService;


    public AdminController(MovieDAO movieDAO, MovieService movieService) {
        this.movieDAO = movieDAO;
        this.movieService = movieService;
    }

    @RequestMapping("/deleteMovie")
    String deleteMovieById(@RequestParam int id) {
        String movieName = movieDAO.findMovieDTOById(id).getName();
        MovieDTO movieDTO = movieDAO.findMovieDTOById(id);
        movieDAO.delete(movieDTO);
        log.info("movie {} is removed", movieName);
        return "Movie " + movieName + " is removed";
    }

//    @PostMapping("/addMovie")
//    MovieDTO addMovie(@RequestParam String name, int year, int directorID, String country) {
//
//        MovieDTO movieDTO = movieDAO.saveAndFlush()
//        movieDAO.addMovie(name, year, directorID, country);
//        log.info("movie is added {}, {}, {}, {}", name, year, directorID, country);
//        return movieDAO.findMovieDTOByName(name);
//    }
}
