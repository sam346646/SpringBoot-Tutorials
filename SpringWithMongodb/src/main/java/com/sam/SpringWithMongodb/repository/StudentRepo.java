package com.sam.SpringWithMongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sam.SpringWithMongodb.model.Student;

public interface StudentRepo extends MongoRepository<Student, Long>{

	Optional<Student> findStudentByEmail(String email);

	Student findById(String id);
	
}
