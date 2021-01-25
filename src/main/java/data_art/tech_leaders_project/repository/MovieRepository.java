package data_art.tech_leaders_project.repository;

import data_art.tech_leaders_project.entity.DirectorEntity;
import data_art.tech_leaders_project.entity.GenreEntity;
import data_art.tech_leaders_project.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    MovieEntity findMovieEntityByName(String name);

    List<MovieEntity> findAllMovieEntityByYear(int year);

    List<MovieEntity> findAllMovieEntityByDirectorEntity(DirectorEntity directorEntity);

    List<MovieEntity> findAllMovieEntityByGenres(GenreEntity genreEntity);

    MovieEntity findMovieEntityById(int id);

}
