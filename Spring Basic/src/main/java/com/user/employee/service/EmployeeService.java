package com.user.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.employee.exception.EmployeeNotFoundException;
import com.user.employee.model.Employee;
import com.user.employee.repo.EmployeeRepo;

@Service
public class EmployeeService {
	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() ->  new EmployeeNotFoundException("Employee with id "+id+" not found."));
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		Optional<Employee> employee = employeeRepo.findEmployeeById(id);
	    if (employee.isPresent()) {
	        employeeRepo.deleteById(id);
	    } else {
	        throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
	    }
	}
}
