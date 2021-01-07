package data_art.tech_leaders_project.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@ToString(exclude = "movies")
@Entity
@Table (name = "genres")
public class GenreDTO {
    @Id
    private int id;
    private String genre_name;
}
