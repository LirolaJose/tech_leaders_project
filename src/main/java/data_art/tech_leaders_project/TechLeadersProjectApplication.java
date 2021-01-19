package data_art.tech_leaders_project;


import data_art.tech_leaders_project.dao.DirectorDAO;
import data_art.tech_leaders_project.dao.GenreDAO;
import data_art.tech_leaders_project.dao.MovieDAO;
import data_art.tech_leaders_project.dto.DirectorDTO;
import data_art.tech_leaders_project.dto.GenreDTO;
import data_art.tech_leaders_project.services.DirectorService;
import data_art.tech_leaders_project.services.GenreService;
import data_art.tech_leaders_project.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan ("data_art")
@EntityScan ("data_art.tech_leaders_project.dto")
@EnableJpaRepositories (basePackages = "data_art.tech_leaders_project.dao")
@Slf4j
public class TechLeadersProjectApplication implements CommandLineRunner {

    final MovieDAO movieDAO;
    final DirectorDAO directorDAO;
    final GenreDAO genreDAO;
    final MovieService movieService;
    final DirectorService directorService;
    final GenreService genreService;

    public TechLeadersProjectApplication(MovieDAO movieDAO, MovieService movieService, DirectorService directorService, GenreService genreService, DirectorDAO directorDAO, GenreDAO genreDAO) {
        this.movieDAO = movieDAO;
        this.movieService = movieService;
        this.directorService = directorService;
        this.genreService = genreService;
        this.directorDAO = directorDAO;
        this.genreDAO = genreDAO;
    }





    public static void main(String[] args) {
		log.info("Application is run");
        SpringApplication.run(TechLeadersProjectApplication.class, args);
	}



    @Override
    public void run(String... args) throws Exception {
        DirectorDTO directorDTO = directorDAO.findById(6);
        GenreDTO genreDTO = genreDAO.findById(3);
        System.out.println("---run---");
//        System.out.println(movieService.getMovies());
//        System.out.println(movieService.getMovieByName("The Matrix"));
//        System.out.println(movieService.getAllMovieByYear(2003));
//        System.out.println(movieService.getAllMoviesByDirector(directorDTO));
//        System.out.println(movieService.getAllMoviesByGenre(genreDTO));
        System.out.println(movieService.getMovieById(7));
        System.out.println(directorDAO.findDirectorDTOByNameOrLast_name("Spielberg", "Spielberg"));
        movieService.addMovie("Film", 2021, 1, "Ukraine");
        System.out.println("---run---");
    }
}
