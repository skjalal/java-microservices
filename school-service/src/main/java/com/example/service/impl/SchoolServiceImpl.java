package com.example.service.impl;

import com.example.mapper.SchoolMapper;
import com.example.model.SchoolDTO;
import com.example.repository.SchoolRepository;
import com.example.service.SchoolService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SchoolServiceImpl implements SchoolService {

  private final SchoolRepository schoolRepository;
  private final SchoolMapper schoolMapper;

  @Override
  public SchoolDTO addSchool(SchoolDTO school) {
    return schoolMapper.toDTO(schoolRepository.save(schoolMapper.toEntity(school)));
  }

  @Override
  public List<SchoolDTO> fetchSchools() {
    return schoolRepository.findAll().stream().map(schoolMapper::toDTO).toList();
  }

  @Override
  public SchoolDTO fetchSchoolById(int id) {
    return schoolRepository.findById(id).map(schoolMapper::toDTO).orElseGet(SchoolDTO::new);
  }
}
