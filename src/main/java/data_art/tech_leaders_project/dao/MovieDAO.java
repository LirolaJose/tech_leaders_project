package data_art.tech_leaders_project.dao;

import data_art.tech_leaders_project.dto.MovieDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDAO extends JpaRepository<MovieDTO, Integer> {
    /*List<MovieDTO> getMovies();*/
    MovieDTO findTopByNameOrderByNameDesc(String name);
}
