package ro.homework.task9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;
import ro.homework.task9.entities.FileData;

import java.util.UUID;

public interface FileDataRepository extends JpaRepository<FileData, UUID> {

}
