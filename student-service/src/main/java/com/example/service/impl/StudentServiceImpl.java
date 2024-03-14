package com.example.service.impl;

import com.example.domain.Student;
import com.example.mapper.StudentMapper;
import com.example.model.SchoolDTO;
import com.example.model.StudentDTO;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;
  private final RestTemplate restTemplate;

  @Override
  public StudentDTO createStudent(StudentDTO student) {
    var objectId = new ObjectId();
    student.setId(Optional.ofNullable(student.getId()).orElseGet(objectId::toString));
    var schoolId =
        Optional.ofNullable(student.getSchool())
            .flatMap(d -> Optional.ofNullable(d.getId()))
            .orElseThrow();
    var school = restTemplate.getForObject(SCHOOL_SERVICE_URL + schoolId, SchoolDTO.class);
    student.setSchool(school);
    var updatedStudent = studentMapper.toDTO(studentRepository.save(studentMapper.toEntity(student)));
    updatedStudent.setSchool(school);
    return updatedStudent;
  }

  @Override
  public StudentDTO fetchStudentById(String id) {
    var student = studentRepository.findById(new ObjectId(id)).orElseThrow();
    var school =
        restTemplate.getForObject(SCHOOL_SERVICE_URL + student.getSchoolId(), SchoolDTO.class);
    var dto = studentMapper.toDTO(student);
    dto.setSchool(school);
    return dto;
  }

  @Override
  public List<StudentDTO> fetchStudents() {
    return studentRepository.findAll().stream().map(this::mapValues).toList();
  }

  private StudentDTO mapValues(Student student) {
    var school =
        restTemplate.getForObject(SCHOOL_SERVICE_URL + student.getSchoolId(), SchoolDTO.class);
    var dto = studentMapper.toDTO(student);
    dto.setSchool(school);
    return dto;
  }
}
