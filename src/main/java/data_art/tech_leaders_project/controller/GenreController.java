package data_art.tech_leaders_project.controller;

import data_art.tech_leaders_project.dao.GenreRepository;
import data_art.tech_leaders_project.dto.GenreEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@Slf4j
public class GenreController {
    final
    GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @RequestMapping("/genres")
    public Set<GenreEntity> getAllGenres(){
        log.info("show all genres in localhost 8081");
        return genreRepository.findAllBy();
    }
}
