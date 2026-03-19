package com.capgemini.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.model.entity.University;

public interface UniversityRepository extends JpaRepository<University, Integer> {
}