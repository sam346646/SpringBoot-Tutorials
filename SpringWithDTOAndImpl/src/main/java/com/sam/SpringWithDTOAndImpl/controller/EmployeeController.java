package com.sam.SpringWithDTOAndImpl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.SpringWithDTOAndImpl.dto.EmployeeDto;
import com.sam.SpringWithDTOAndImpl.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public EmployeeDto addEmployee(@RequestBody EmployeeDto employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/all")
	public List<EmployeeDto> getAllEmployees() {
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/byId/{id}")
	public EmployeeDto getEmployeeById(@PathVariable Long id) throws Exception {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/byName/{name}")
	public EmployeeDto getEmployeeById(@PathVariable String name) throws Exception {
		return employeeService.getEmployeeByName(name);
	}
	
	@PutMapping("/update")
	public EmployeeDto updatEmployee(@RequestBody EmployeeDto employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
	}
}
