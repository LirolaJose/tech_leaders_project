package data_art.tech_leaders_project.services.servicesIMPL;

import data_art.tech_leaders_project.dao.DirectorDAO;
import data_art.tech_leaders_project.dto.DirectorDTO;
import data_art.tech_leaders_project.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {
    @Autowired
    DirectorDAO directorDAO;

    @Override
    public List<DirectorDTO> findAllDirectors() {
        return directorDAO.findAll();
    }
}
