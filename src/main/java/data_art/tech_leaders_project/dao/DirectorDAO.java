package data_art.tech_leaders_project.dao;

import data_art.tech_leaders_project.dto.DirectorDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorDAO extends JpaRepository <DirectorDTO, Integer> {
    List<DirectorDTO> getAllBy();
}
