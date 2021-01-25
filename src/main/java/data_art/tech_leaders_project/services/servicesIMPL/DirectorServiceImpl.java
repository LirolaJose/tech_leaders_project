package data_art.tech_leaders_project.services.servicesIMPL;

import data_art.tech_leaders_project.repository.DirectorRepository;
import data_art.tech_leaders_project.entity.DirectorEntity;
import data_art.tech_leaders_project.services.DirectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DirectorServiceImpl implements DirectorService {
    final DirectorRepository directorRepository;

    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public List<DirectorEntity> getAllDirectors() {
        log.info("get info about all directors");
        return directorRepository.findAll();
    }

    @Override
    public void addDirector(String name, String lastName) {
        log.info("adding new Director {}, {}", name, lastName);
        DirectorEntity directorEntity = new DirectorEntity();

        directorEntity.setName(name);
        directorEntity.setLast_name(lastName);
        directorRepository.save(directorEntity);
        log.info("new Director is added {}, {}", name, lastName);
    }
}
