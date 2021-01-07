package data_art.tech_leaders_project.services.servicesIMPL;

import data_art.tech_leaders_project.dao.DirectorDAO;
import data_art.tech_leaders_project.dto.DirectorDTO;
import data_art.tech_leaders_project.services.DirectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DirectorServiceImpl implements DirectorService {
    final DirectorDAO directorDAO;

    public DirectorServiceImpl(DirectorDAO directorDAO) {
        this.directorDAO = directorDAO;
    }

    @Override
    public List<DirectorDTO> getAllDirectors() {
        log.info("get info about all directors");
        return directorDAO.findAll();
    }
}
