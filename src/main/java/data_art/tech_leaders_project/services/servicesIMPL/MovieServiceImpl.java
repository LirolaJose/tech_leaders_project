package data_art.tech_leaders_project.services.servicesIMPL;

import data_art.tech_leaders_project.repository.DirectorRepository;
import data_art.tech_leaders_project.repository.GenreRepository;
import data_art.tech_leaders_project.repository.MovieRepository;
import data_art.tech_leaders_project.entity.DirectorEntity;
import data_art.tech_leaders_project.entity.GenreEntity;
import data_art.tech_leaders_project.entity.MovieEntity;
import data_art.tech_leaders_project.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {
    final MovieRepository movieRepository;
    final DirectorRepository directorRepository;
    final GenreRepository genreRepository;

    public MovieServiceImpl(MovieRepository dao, DirectorRepository directorRepository, GenreRepository genreRepository) {
        this.movieRepository = dao;
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<MovieEntity> getMovies() {
        log.info("get all movies");
        return movieRepository.findAll();
    }

    @Override
    public MovieEntity getMovieByName(String name) {
        log.info("get movie by name {}", name);
        return movieRepository.findMovieEntityByName(name);
    }

    @Override
    public List<MovieEntity> getAllMovieByYear(int year) {
        log.info("get list movies by year {}", year);
        return movieRepository.findAllMovieEntityByYear(year);
    }

    @Override
    public List<MovieEntity> getAllMoviesByDirector(DirectorEntity directorEntity) {
        log.info("get list of movies by director {}", directorEntity.getLast_name());
        return movieRepository.findAllMovieEntityByDirectorEntity(directorEntity);
    }

    @Override
    public List<MovieEntity> getAllMoviesByGenre(GenreEntity genreEntity) {
        log.info("get list of movie by genre {}", genreEntity.getGenre_name());
        return movieRepository.findAllMovieEntityByGenres(genreEntity);
    }

    @Override
    public MovieEntity getMovieById(int id) {
        log.info("get movie by id {}", id);
        return movieRepository.findMovieEntityById(id);
    }

    @Modifying
    @Override
    public void addMovie(String name, int year, int directorId, String country, List<Integer> genres){
        log.info("adding new movie: {},{},{},{},{}", name, year, directorId, country, genres);
        MovieEntity movieEntity = new MovieEntity();
        Set<GenreEntity> genresSet = new HashSet<>();

        movieEntity.setName(name);
        movieEntity.setYear(year);
        movieEntity.setCountry(country);
        movieEntity.setDirectorEntity(directorRepository.findById(directorId));

        for(int value:genres) {
            genresSet.add(genreRepository.findById(value));
        }
        movieEntity.setGenres(genresSet);

        movieRepository.save(movieEntity);
        log.info("new Movie is added: {}", movieEntity.getName());
    }


//    @Override
//    public void deleteMovieById(int id) {
//        log.info("delete movie by id {}", id);
//        movieDAO.deleteMovieDTOById(id);
//    }

}


