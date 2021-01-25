package data_art.tech_leaders_project.repository;

import data_art.tech_leaders_project.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface GenreRepository extends JpaRepository <GenreEntity, Integer> {
    GenreEntity findById(int id);
    Set<GenreEntity> findAllBy();
}
