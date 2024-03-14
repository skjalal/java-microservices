package com.example.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDTO {
  String id;
  String name;
  Integer age;
  String gender;
  SchoolDTO school;
}
