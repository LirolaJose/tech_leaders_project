package data_art.tech_leaders_project.dao;

import data_art.tech_leaders_project.dto.DirectorEntity;
import data_art.tech_leaders_project.dto.GenreEntity;
import data_art.tech_leaders_project.dto.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    MovieEntity findMovieEntityByName(String name);

    List<MovieEntity> findAllMovieEntityByYear(int year);

    List<MovieEntity> findAllMovieEntityByDirectorEntity(DirectorEntity directorEntity);

    List<MovieEntity> findAllMovieEntityByGenres(GenreEntity genreEntity);

    MovieEntity findMovieEntityById(int id);

    void deleteMovieEntityById(int id);

//    MovieEntity addMovie(String name, int year, int director_id, String country, int...genres);

}
