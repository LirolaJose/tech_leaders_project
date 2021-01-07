package data_art.tech_leaders_project.dao;

import data_art.tech_leaders_project.dto.DirectorDTO;
import data_art.tech_leaders_project.dto.GenreDTO;
import data_art.tech_leaders_project.dto.MovieDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDAO extends JpaRepository<MovieDTO, Integer> {
    MovieDTO findTopByNameOrderByNameDesc(String name);
    List<MovieDTO> findAllMovieDTOByYear(int year);
    List<MovieDTO> findAllMovieDTOByDirectorDTO(DirectorDTO directorDTO);
    List<MovieDTO> findAllMovieDTOByGenres(GenreDTO genreDTO);
}
