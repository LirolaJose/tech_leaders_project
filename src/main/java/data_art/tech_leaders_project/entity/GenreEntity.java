package data_art.tech_leaders_project.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(exclude = "movies")
@Entity
@Table (name = "genres")
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String genre_name;
}
