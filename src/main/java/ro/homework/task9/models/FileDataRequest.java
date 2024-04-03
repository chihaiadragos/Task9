package ro.homework.task9.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
public class FileDataRequest {

    @Id
    @GeneratedValue
    private UUID id;

    private String fileName;
    private String extension;
    private Integer sizeInKb;
    private String content;


}
