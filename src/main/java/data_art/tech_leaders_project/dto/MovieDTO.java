package data_art.tech_leaders_project.dto;

import lombok.Data;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table (name = "movies")
public class MovieDTO {
    @Id
    private int id;
    private String name;
    private Integer year;
    private Integer director_id;
    private String country;
}
