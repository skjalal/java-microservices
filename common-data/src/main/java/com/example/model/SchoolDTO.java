package com.example.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchoolDTO {

  Integer id;
  String schoolName;
  String location;
  String principalName;
}
