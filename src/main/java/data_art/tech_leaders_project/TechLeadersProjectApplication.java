package data_art.tech_leaders_project;


import data_art.tech_leaders_project.services.DirectorService;
import data_art.tech_leaders_project.services.GenreService;
import data_art.tech_leaders_project.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TechLeadersProjectApplication implements CommandLineRunner {

    final MovieService movieService;
    final DirectorService directorService;
    final GenreService genreService;

    public TechLeadersProjectApplication(MovieService movieService, DirectorService directorService, GenreService genreService) {
        this.movieService = movieService;
        this.directorService = directorService;
        this.genreService = genreService;
    }



    public static void main(String[] args) {
		SpringApplication.run(TechLeadersProjectApplication.class, args);
	}



    @Override
    public void run(String... args) throws Exception {
        System.out.println("---run---");
        System.out.println(movieService.findMovieByName("Inception"));
        System.out.println(genreService.getAllGenres());
        System.out.println("---run---");
    }
}
/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}*/