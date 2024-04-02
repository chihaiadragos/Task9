package ro.homework.task9.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "files_data")
public class FileData {

    @Id
    @GeneratedValue
    private UUID id;

    private String fileName;
    private String extension;
    private Integer sizeInKb;
    private String content;


}
