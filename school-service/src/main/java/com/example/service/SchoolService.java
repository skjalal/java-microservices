package com.example.service;

import com.example.model.SchoolDTO;
import java.util.List;

public interface SchoolService {

  SchoolDTO addSchool(SchoolDTO school);

  List<SchoolDTO> fetchSchools();

  SchoolDTO fetchSchoolById(int id);
}
