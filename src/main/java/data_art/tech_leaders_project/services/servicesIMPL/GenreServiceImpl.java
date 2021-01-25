package data_art.tech_leaders_project.services.servicesIMPL;

import data_art.tech_leaders_project.repository.GenreRepository;
import data_art.tech_leaders_project.entity.GenreEntity;
import data_art.tech_leaders_project.services.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GenreServiceImpl implements GenreService {
    final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository dao) {
        this.genreRepository = dao;
    }

    @Override
    public List<GenreEntity> getAllGenres() {
        log.info("get all genres");
        return genreRepository.findAll();
    }
}
