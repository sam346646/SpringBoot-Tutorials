package com.sam.springboot.SpringTutorialYoutube.repository;

import org.springframework.data.repository.CrudRepository;

import com.sam.springboot.SpringTutorialYoutube.model.Student;

public interface StudentRepository extends CrudRepository<Student, String>{

}
