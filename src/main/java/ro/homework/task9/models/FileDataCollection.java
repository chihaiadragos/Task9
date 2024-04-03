package ro.homework.task9.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FileDataCollection {
    private List<FileDataResponse> files;

}
