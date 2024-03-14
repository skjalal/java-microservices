package com.example.mapper;

import com.example.domain.School;
import com.example.model.SchoolDTO;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.util.StringUtils;

@Mapper
public interface SchoolMapper {

  @Mappings(
      value = {
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "schoolName", source = "schoolName"),
        @Mapping(target = "location", source = "location"),
        @Mapping(target = "principalName", source = "principalName")
      })
  SchoolDTO toDTO(School school);

  @Mappings(
      value = {
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "schoolName", source = "schoolName"),
        @Mapping(target = "location", source = "location"),
        @Mapping(target = "principalName", source = "principalName")
      })
  School toEntity(SchoolDTO schoolDTO);

  @Condition
  default boolean isNotEmpty(String value) {
    return StringUtils.hasText(value);
  }
}
