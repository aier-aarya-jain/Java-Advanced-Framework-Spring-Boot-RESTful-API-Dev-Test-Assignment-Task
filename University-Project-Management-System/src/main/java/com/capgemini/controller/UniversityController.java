package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.model.entity.University;
import com.capgemini.model.service.UniversityService;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityService service;

    @PostMapping
    public University createUniversity(@RequestBody University university) {
        return service.saveUniversity(university);
    }
    @PostMapping("/bulk")
    public List<University> createBulk(@RequestBody List<University> universities) {
        return service.saveAll(universities);
    }
    
    @GetMapping
    public List<University> getAll() {
        return service.getAllUniversities();
    }

    @GetMapping("/{id}")
    public University getById(@PathVariable Integer id) {
        return service.getUniversityById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteUniversity(id);
        return "Deleted Successfully";
    }
}