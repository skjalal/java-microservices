package com.example.controller;

import com.example.model.StudentDTO;
import com.example.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class StudentController {

  private final StudentService studentService;

  @GetMapping("/{id}")
  public StudentDTO fetchStudentById(@PathVariable(value = "id") String id) {
    return studentService.fetchStudentById(id);
  }

  @GetMapping
  public List<StudentDTO> fetchStudents() {
    return studentService.fetchStudents();
  }

  @PostMapping
  public StudentDTO createStudent(@RequestBody StudentDTO student) {
    return studentService.createStudent(student);
  }
}
