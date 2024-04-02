package ro.homework.task9.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.homework.task9.entities.FileData;
import ro.homework.task9.repositories.FileDataRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/files-data")
public class FileDataController {
    @Autowired
    private FileDataRepository fileDataRepository;
    @GetMapping
    public List<FileData> getAllFileData() {
        return fileDataRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<FileData> saveFileData(@RequestBody FileData fileData) throws URISyntaxException {
        FileData result = fileDataRepository.save(fileData);

        URI resourceUri = new URI("/api/files-data/"+result.getId());
        return ResponseEntity.created(resourceUri).build();
    }
}
