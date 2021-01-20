package data_art.tech_leaders_project.dao;

import data_art.tech_leaders_project.dto.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface GenreRepository extends JpaRepository <GenreEntity, Integer> {
    GenreEntity findById(int id);
    Set<GenreEntity> findAllBy();
}
