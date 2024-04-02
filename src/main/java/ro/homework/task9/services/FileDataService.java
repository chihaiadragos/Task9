package ro.homework.task9.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.homework.task9.entities.FileData;
import ro.homework.task9.exceptions.SdaException;
import ro.homework.task9.models.FileDataCollection;
import ro.homework.task9.repositories.FileDataRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FileDataService {

    private final FileDataRepository fileDataRepository;

    public FileDataCollection findAll() {
        return FileDataCollection.builder().files(fileDataRepository.findAll()).build();
    }

    public FileData create(FileData fileData) {
        fileData.setId(null);

        return fileDataRepository.save(fileData);
    }

    public FileData retrieveById(UUID id) {
        return fileDataRepository.findById(id).orElseThrow(()->new SdaException("Could not retrieve file with id"+id));
    }
}