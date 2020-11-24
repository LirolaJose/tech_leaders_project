package data_art.tech_leaders_project.services.servicesIMPL;

import data_art.tech_leaders_project.dao.GenreDAO;
import data_art.tech_leaders_project.dto.GenreDTO;
import data_art.tech_leaders_project.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    GenreDAO dao;

    @Override
    public List<GenreDTO> getAllGenres() {
        return dao.findAll();
    }
}
