package ro.homework.task9.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.homework.task9.entities.FileData;
import ro.homework.task9.repositories.FileDataRepository;

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
}
