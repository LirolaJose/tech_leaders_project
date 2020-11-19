package data_art.tech_leaders_project.controller;

import data_art.tech_leaders_project.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    MovieService service;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!" + service.getMovies();
    }

}
