package data_art.tech_leaders_project.controller.admin;

import data_art.tech_leaders_project.controller.model.AddMovieForm;
import data_art.tech_leaders_project.dao.DirectorRepository;
import data_art.tech_leaders_project.dao.GenreRepository;
import data_art.tech_leaders_project.dao.MovieRepository;
import data_art.tech_leaders_project.dto.DirectorEntity;
import data_art.tech_leaders_project.dto.MovieEntity;
import data_art.tech_leaders_project.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
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

    @PostMapping("/addMovie") // why I used the @RequestMapping instead @Post
    String addMovie(@RequestBody AddMovieForm form) {
        movieService.addMovie(form.getName(), form.getYear(), form.getDirectorId(), form.getCountry(), form.getGenres());
        log.info("new movie is added: {}", form.getName());
        return "New movie is added: " + form.getName();
    }
}
