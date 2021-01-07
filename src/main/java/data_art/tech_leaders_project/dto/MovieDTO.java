package data_art.tech_leaders_project.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table (name = "movies")
public class MovieDTO {
    @Id
    private int id;
    private String name;
    private Integer year;
    private String country;
    @OneToOne
    @JoinColumn (name = "director_id")
    private DirectorDTO directorDTO;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "genre_of_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<GenreDTO> genres;

}
