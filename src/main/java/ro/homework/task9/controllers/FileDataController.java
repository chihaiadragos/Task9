package ro.homework.task9.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.homework.task9.exceptions.SdaException;
import ro.homework.task9.models.FileDataCollection;
import ro.homework.task9.models.FileDataRequest;
import ro.homework.task9.models.FileDataResponse;
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
    public ResponseEntity<FileDataResponse> saveFileData(@RequestBody FileDataRequest fileData) throws URISyntaxException {
        FileDataResponse result = service.create(fileData);

        URI resourceUri = new URI(API_FILES_DATA+result.getId());
        return ResponseEntity.created(resourceUri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<FileDataResponse> updateFileData(@PathVariable UUID id, @RequestBody FileDataRequest fileData) {
        service.update(id, fileData);
       return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
//       return ResponseEntity.noContent().build();
    }
    @GetMapping("{id}")
    public FileDataResponse getById(@PathVariable UUID id){
        return service.retrieveById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFileDate(@PathVariable UUID id) {
        service.delete(id);

    }

    @ExceptionHandler(SdaException.class)
    public ResponseEntity<String> handleSdaException(SdaException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
