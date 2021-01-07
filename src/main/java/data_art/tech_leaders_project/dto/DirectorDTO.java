package data_art.tech_leaders_project.dto;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table (name = "directors")
public class DirectorDTO {
    @Id
    private int id;
    private String name;
    private String last_name;
}
