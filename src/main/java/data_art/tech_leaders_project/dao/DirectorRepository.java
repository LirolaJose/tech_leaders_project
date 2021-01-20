package data_art.tech_leaders_project.dao;

import data_art.tech_leaders_project.dto.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DirectorRepository extends JpaRepository<DirectorEntity, Integer> {
    DirectorEntity findById(int id);

    @Query(value = "SELECT * FROM directors d WHERE d.name = ?1 OR d.last_name = ?2", nativeQuery = true)
    DirectorEntity findDirectorEntityByNameOrLast_name(String name, String lastName);
}
