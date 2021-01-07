package data_art.tech_leaders_project.controller;

import data_art.tech_leaders_project.dao.DirectorDAO;
import data_art.tech_leaders_project.dto.DirectorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DirectorController {
    final
    DirectorDAO directorDAO;

    public DirectorController(DirectorDAO directorDAO) {
        this.directorDAO = directorDAO;
    }

    @RequestMapping("/Directors")
    public List<DirectorDTO> getAllDirectors(){
        log.info("show all directors in localhost 8081");
        return directorDAO.findAll();
    }
}
