package com.example.mapper;

import com.example.domain.Student;
import com.example.model.StudentDTO;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface StudentMapper {

  @Mappings(
      value = {
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "name", source = "name"),
        @Mapping(target = "age", source = "age"),
        @Mapping(target = "gender", source = "gender"),
        @Mapping(target = "school", ignore = true)
      })
  StudentDTO toDTO(Student student);

  @Mappings(
      value = {
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "name", source = "name"),
        @Mapping(target = "age", source = "age"),
        @Mapping(target = "gender", source = "gender"),
        @Mapping(target = "schoolId", source = "school.id")
      })
  Student toEntity(StudentDTO studentDTO);

  default String map(ObjectId id) {
    return id.toString();
  }

  default ObjectId map(String id) {
      return new ObjectId(id);
  }
}
