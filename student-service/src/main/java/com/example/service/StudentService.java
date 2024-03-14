package com.example.service;

import com.example.model.StudentDTO;
import java.util.List;

public interface StudentService {

  String SCHOOL_SERVICE_URL = "http://school-service/school/";

  StudentDTO createStudent(StudentDTO student);

  StudentDTO fetchStudentById(String id);

  List<StudentDTO> fetchStudents();
}
