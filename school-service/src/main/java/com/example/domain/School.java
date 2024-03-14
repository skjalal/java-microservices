package com.example.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "school")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class School {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Integer id;

  String schoolName;
  String location;
  String principalName;
}
