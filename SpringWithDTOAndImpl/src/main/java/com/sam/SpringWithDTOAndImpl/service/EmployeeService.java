package com.sam.SpringWithDTOAndImpl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.SpringWithDTOAndImpl.model.Employee;
import com.sam.SpringWithDTOAndImpl.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}
	
	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepo.findById(id);
	}
	
	public Optional<Employee> getEmployeeByName(String name) {
		return employeeRepo.findByName(name);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public void deleteEmployeeById(Long id) {
		employeeRepo.deleteById(id);
	}
}
