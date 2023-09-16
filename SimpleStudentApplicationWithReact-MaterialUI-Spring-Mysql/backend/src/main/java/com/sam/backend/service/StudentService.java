package com.sam.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.backend.model.Student;
import com.sam.backend.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;
	
	public void addStudent(Student student) {
		repo.save(student);
	}

	public List<Student> getAllStudent() {
		return repo.findAll();
	}

}

