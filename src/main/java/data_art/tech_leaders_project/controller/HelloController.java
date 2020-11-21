package data_art.tech_leaders_project.controller;

import data_art.tech_leaders_project.dto.MovieDTO;
import data_art.tech_leaders_project.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    MovieService service;

    @RequestMapping("/Movie")
    public List<MovieDTO> getMovies() {
        return service.getMovies();
    }

}
