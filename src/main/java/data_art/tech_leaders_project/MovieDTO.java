package data_art.tech_leaders_project;

import lombok.Data;

import java.util.Date;

@Data
public class MovieDTO {
    private int id;
    private String name;
    private Date year;
    private int director_id;
    private String country;
}
