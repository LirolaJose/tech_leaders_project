package data_art.tech_leaders_project.dao;

import data_art.tech_leaders_project.dto.DirectorDTO;
import data_art.tech_leaders_project.dto.GenreDTO;
import data_art.tech_leaders_project.dto.MovieDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieDAO extends JpaRepository<MovieDTO, Integer> {
    MovieDTO findMovieDTOByName(String name);

    List<MovieDTO> findAllMovieDTOByYear(int year);

    List<MovieDTO> findAllMovieDTOByDirectorDTO(DirectorDTO directorDTO);

    List<MovieDTO> findAllMovieDTOByGenres(GenreDTO genreDTO);

    MovieDTO findMovieDTOById(int id);

    void deleteMovieDTOById(int id);

//    @Query(value = "INSERT INTO movies m (m.name, m.year, m.director_id, m.country) VALUES (?,?,?,?)", nativeQuery = true)
//    void addMovie (@Param("name") String name, @Param(year) int year, int director_id, String country);
}
