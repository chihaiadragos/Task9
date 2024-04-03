package ro.homework.task9.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.homework.task9.entities.FileData;
import ro.homework.task9.exceptions.SdaException;
import ro.homework.task9.models.FileDataCollection;
import ro.homework.task9.models.FileDataRequest;
import ro.homework.task9.models.FileDataResponse;
import ro.homework.task9.repositories.FileDataRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileDataService {

    private final FileDataRepository fileDataRepository;

    private FileDataMapper fileDataMapper = FileDataMapper.INSTANCE;

    public FileDataCollection findAll() {
        return FileDataCollection.builder().files(fileDataRepository.findAll().stream().map(fileDataMapper::toFileDataResponseFromEntity).toList()).build();
    }

    public FileDataResponse create(FileDataRequest fileData) {
        FileData entity = fileDataMapper.toEntityFromRequest(fileData);
        entity.setId(null);
        return fileDataMapper.toFileDataResponseFromEntity(fileDataRepository.save(entity));
    }

    public FileDataResponse retrieveById(UUID id) {
        FileData entity = getFileDataEntity(id);

        return fileDataMapper.toFileDataResponseFromEntity(entity);
    }

    private FileData getFileDataEntity(UUID id) {
        return fileDataRepository.findById(id).orElseThrow(()->new SdaException("Could not retrieve file with id"+ id));
    }

    public void update(UUID id, FileDataRequest fileData) {
       FileData entity= getFileDataEntity(id);
       entity.setExtension(fileData.getExtension());
       entity.setFileName(fileData.getFileName());
       entity.setContent(fileData.getContent());
       entity.setSizeInKb(fileData.getSizeInKb());
       fileDataRepository.save(entity);
    }

    public void delete(UUID id) {
        FileData entity= getFileDataEntity(id);
//        fileDataRepository.deleteById(id);
        fileDataRepository.delete(entity);
    }
}
