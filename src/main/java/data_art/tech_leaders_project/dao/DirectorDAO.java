package data_art.tech_leaders_project.dao;

import data_art.tech_leaders_project.dto.DirectorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DirectorDAO extends JpaRepository<DirectorDTO, Integer> {
    DirectorDTO findById(int id);

    @Query(value = "SELECT * FROM directors d WHERE d.name = ?1 OR d.last_name = ?2", nativeQuery = true)
    DirectorDTO findDirectorDTOByNameOrLast_name(String name, String lastName);
}
