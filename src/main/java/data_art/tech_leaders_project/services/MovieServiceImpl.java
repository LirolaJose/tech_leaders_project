package data_art.tech_leaders_project.services;

import data_art.tech_leaders_project.dto.MovieDTO;
import data_art.tech_leaders_project.dao.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieDAO dao;

    @Override
    public List<MovieDTO> getMovies() {
        return dao.findAll();
    }

    @Override
    public MovieDTO findMovieByName(String name) {
        return dao.findTopByNameOrderByNameDesc(name);
    }
}
