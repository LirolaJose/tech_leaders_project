package data_art.tech_leaders_project.controller;

import data_art.tech_leaders_project.dao.GenreDAO;
import data_art.tech_leaders_project.dto.GenreDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@Slf4j
public class GenreController {
    final
    GenreDAO genreDAO;

    public GenreController(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    @RequestMapping("/genres")
    public Set<GenreDTO> getAllGenres(){
        log.info("show all genres in localhost 8081");
        return genreDAO.findAllBy();
    }
}
