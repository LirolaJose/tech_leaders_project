package data_art.tech_leaders_project.controller;

import data_art.tech_leaders_project.dao.DirectorRepository;
import data_art.tech_leaders_project.dto.DirectorEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DirectorController {
    final
    DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @RequestMapping("/directors")
    public List<DirectorEntity> getAllDirectors(){
        log.info("show all directors in localhost 8081");
        return directorRepository.findAll();
    }
}
