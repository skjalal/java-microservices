package com.example.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "students")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

  @Id
  @Field(name = "_id")
  ObjectId id;

  String name;
  Integer age;
  String gender;
  Integer schoolId;
}
