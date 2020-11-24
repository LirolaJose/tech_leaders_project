package data_art.tech_leaders_project.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table (name = "genres")
public class GenreDTO {
    @Id
    private int id;
    private String genre_name;
}
