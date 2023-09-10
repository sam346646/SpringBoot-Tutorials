package com.sam.springboot.SpringTutorialYoutube.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sam.springboot.SpringTutorialYoutube.model.Student;
import com.sam.springboot.SpringTutorialYoutube.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> students=studentService.getAllStudents();
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable String id){
		Optional<Student> students=studentService.getStudentById(id);
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	@PostMapping("/student/add")
	public void addStudent(@RequestBody Student student){
		studentService.addStudent(student);
	}
	
	@PutMapping("/student/update")
	public void updateStudent(@RequestBody Student student){
		studentService.updateStudent(student);
	}
	
	@DeleteMapping("/student/delete/{id}")
	public void deleteStudent(@PathVariable String id){
		studentService.deleteStudent(id);
	}
}

