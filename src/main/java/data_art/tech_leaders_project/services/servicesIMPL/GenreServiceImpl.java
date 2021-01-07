package data_art.tech_leaders_project.services.servicesIMPL;

import data_art.tech_leaders_project.dao.GenreDAO;
import data_art.tech_leaders_project.dto.GenreDTO;
import data_art.tech_leaders_project.services.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GenreServiceImpl implements GenreService {
    final GenreDAO genreDAO;

    public GenreServiceImpl(GenreDAO dao) {
        this.genreDAO = dao;
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        log.info("get all genres");
        return genreDAO.findAll();
    }
}
