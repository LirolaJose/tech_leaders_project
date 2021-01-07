package data_art.tech_leaders_project.dao;

import data_art.tech_leaders_project.dto.GenreDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface GenreDAO extends JpaRepository <GenreDTO, Integer> {
    GenreDTO findById(int id);
    Set<GenreDTO> findAllBy();
}
