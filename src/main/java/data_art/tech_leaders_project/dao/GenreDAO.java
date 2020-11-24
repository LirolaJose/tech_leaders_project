package data_art.tech_leaders_project.dao;

import data_art.tech_leaders_project.dto.GenreDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDAO extends JpaRepository <GenreDTO, Integer> {

}
