package com.sam.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.backend.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
