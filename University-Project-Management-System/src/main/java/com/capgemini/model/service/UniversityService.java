package com.capgemini.model.service;		

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.entity.University;
import com.capgemini.model.repository.UniversityRepository;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository repository;

    public University saveUniversity(University university) {
        return repository.save(university);
    }
    public List<University> saveAll(List<University> universities) {
        return repository.saveAll(universities);
    }
    
    public List<University> getAllUniversities() {
        return repository.findAll();
    }

    public University getUniversityById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteUniversity(Integer id) {
        repository.deleteById(id);
    }
}
