package com.example.controller;

import com.example.model.SchoolDTO;
import com.example.service.SchoolService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/school"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SchoolController {

  private final SchoolService schoolService;

  @PostMapping
  public SchoolDTO addSchool(@RequestBody SchoolDTO school) {
    return schoolService.addSchool(school);
  }

  @GetMapping
  public List<SchoolDTO> fetchSchools() {
    return schoolService.fetchSchools();
  }

  @GetMapping("/{id}")
  public SchoolDTO fetchSchoolById(@PathVariable(value = "id") int id) {
    return schoolService.fetchSchoolById(id);
  }
}
