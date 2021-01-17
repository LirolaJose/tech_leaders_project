package data_art.tech_leaders_project.services.servicesIMPL;

import data_art.tech_leaders_project.dao.MovieDAO;
import data_art.tech_leaders_project.dto.DirectorDTO;
import data_art.tech_leaders_project.dto.GenreDTO;
import data_art.tech_leaders_project.dto.MovieDTO;
import data_art.tech_leaders_project.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {
    final MovieDAO movieDAO;

    public MovieServiceImpl(MovieDAO dao) {
        this.movieDAO = dao;
    }

    @Override
    public List<MovieDTO> getMovies() {
        log.info("get all movies");
        return movieDAO.findAll();
    }

    @Override
    public MovieDTO getMovieByName(String name) {
        log.info("get movie by name {}", name);
        return movieDAO.findTopByNameOrderByNameDesc(name);
    }

    @Override
    public List<MovieDTO> getAllMovieByYear(int year) {
        log.info("get list movies by year {}", year);
        return movieDAO.findAllMovieDTOByYear(year);
    }

    @Override
    public List<MovieDTO> getAllMoviesByDirector(DirectorDTO directorDTO) {
        log.info("get list of movies by director {}", directorDTO.getLast_name());
        return movieDAO.findAllMovieDTOByDirectorDTO(directorDTO);
    }

    @Override
    public List<MovieDTO> getAllMoviesByGenre(GenreDTO genreDTO) {
        log.info("get list of movie by genre {}", genreDTO.getGenre_name());
        return movieDAO.findAllMovieDTOByGenres(genreDTO);
    }

    @Override
    public MovieDTO getMovieById(int id) {
        return movieDAO.findMovieDTOById(id);
    }

}


