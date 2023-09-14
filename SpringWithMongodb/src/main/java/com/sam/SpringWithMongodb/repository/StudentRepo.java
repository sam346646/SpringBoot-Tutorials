package com.sam.SpringWithMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sam.SpringWithMongodb.model.Student;

public interface StudentRepo extends MongoRepository<Student, Long>{

}
