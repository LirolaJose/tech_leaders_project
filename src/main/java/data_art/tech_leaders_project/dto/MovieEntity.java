package data_art.tech_leaders_project.dto;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table (name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Integer year;
    private String country;
    @OneToOne
    @JoinColumn (name = "director_id")
    private DirectorEntity directorEntity;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "genre_of_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<GenreEntity> genres;

}
