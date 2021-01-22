package data_art.tech_leaders_project.controller.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Data
public class AddMovieForm {
    private String name;
    private Integer year;
    private Integer directorId;
    private String country;
    private List<Integer> genres;
}
