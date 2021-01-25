package data_art.tech_leaders_project.controller.admin;

import data_art.tech_leaders_project.controller.model.AddDirectorForm;
import data_art.tech_leaders_project.controller.model.AddMovieForm;
import data_art.tech_leaders_project.repository.DirectorRepository;
import data_art.tech_leaders_project.repository.GenreRepository;
import data_art.tech_leaders_project.repository.MovieRepository;
import data_art.tech_leaders_project.entity.MovieEntity;
import data_art.tech_leaders_project.services.DirectorService;
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
    final DirectorService directorService;


    public AdminController(MovieRepository movieRepository, MovieService movieService, DirectorRepository directorRepository, GenreRepository genreRepository, DirectorService directorService) {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
        this.directorService = directorService;
    }

    @RequestMapping("/deleteMovie")
        // TODO: 1/24/2021 delete mapping 
    String deleteMovieById(@RequestParam int id) {
        String movieName = movieRepository.findMovieEntityById(id).getName();
        MovieEntity movieEntity = movieRepository.findMovieEntityById(id);
        movieRepository.delete(movieEntity);
        log.info("movie {} is removed", movieName);
        return "Movie " + movieName + " is removed";
    }

    @PostMapping("/addMovie")
    void addMovie(@RequestBody AddMovieForm form) {
        movieService.addMovie(form.getName(), form.getYear(), form.getDirectorId(), form.getCountry(), form.getGenres());
        log.info("Controller: new movie is added: {}", form.getName());
    }
    @PostMapping("/addDirector")
    void addDirector(@RequestBody AddDirectorForm form){
        directorService.addDirector(form.getName(), form.getLastName());
        log.info("Controller: new Director is added {}, {}", form.getName(), form.getLastName());
    }
}
