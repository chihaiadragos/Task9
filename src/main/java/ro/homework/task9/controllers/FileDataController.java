package ro.homework.task9.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.homework.task9.entities.FileData;
import ro.homework.task9.exceptions.SdaException;
import ro.homework.task9.models.FileDataCollection;
import ro.homework.task9.services.FileDataService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@RestController
@RequestMapping(FileDataController.API_FILES_DATA)
@AllArgsConstructor
public class FileDataController {

    public static final String API_FILES_DATA = "/api/files-data/";
    private final FileDataService service;
    @GetMapping
    public FileDataCollection getAllFileData() {
        return service.findAll();
    }
    @PostMapping
    public ResponseEntity<FileData> saveFileData(@RequestBody FileData fileData) throws URISyntaxException {
        FileData result = service.create(fileData);

        URI resourceUri = new URI(API_FILES_DATA+result.getId());
        return ResponseEntity.created(resourceUri).build();
    }
    @GetMapping("{id}")
    public FileData getById(@PathVariable UUID id){
        return service.retrieveById(id);
    }

    @ExceptionHandler(SdaException.class)
    public ResponseEntity<String> handleSdaException(SdaException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
