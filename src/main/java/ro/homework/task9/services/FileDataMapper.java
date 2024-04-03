package ro.homework.task9.services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ro.homework.task9.entities.FileData;
import ro.homework.task9.models.FileDataRequest;
import ro.homework.task9.models.FileDataResponse;

@Mapper(componentModel = "spring")
public interface FileDataMapper {

    FileDataMapper INSTANCE = Mappers.getMapper(FileDataMapper.class);
    @Mapping(target = "ext", source = "extension")
    @Mapping(target = "size", source = "sizeInKb")
    FileDataResponse toFileDataResponseFromEntity(FileData entity);
    FileDataRequest toFileDataRequestFromEntity(FileData entity);

    @Mapping(source = "ext", target = "extension")
    @Mapping(source = "size", target = "sizeInKb")
    FileData toEntityFromResponse(FileDataResponse response);

    FileData toEntityFromRequest(FileDataRequest request);


}
