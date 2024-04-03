package ro.homework.task9.models;

import lombok.Data;

import java.util.UUID;

@Data
public class FileDataResponse {

    private UUID id;

    private String fileName;
    private String ext;
    private Integer size;
    private String content;


}
