package data_art.tech_leaders_project.services;

import data_art.tech_leaders_project.entity.DirectorEntity;

import java.util.List;

public interface DirectorService {
    List<DirectorEntity> getAllDirectors();

    void addDirector (String name, String lastName);
}
