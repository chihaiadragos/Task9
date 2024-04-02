package ro.homework.task9.models;

import lombok.Builder;
import lombok.Data;
import ro.homework.task9.entities.FileData;

import java.util.List;

@Data
@Builder
public class FileDataCollection {
    private List<FileData> files;

}
