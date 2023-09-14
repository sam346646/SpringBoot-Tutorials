package com.sam.SpringWithMongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.SpringWithMongodb.model.Student;
import com.sam.SpringWithMongodb.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	public Student getStudentById(String id) {
		return studentRepo.findById(id);
	}

}
