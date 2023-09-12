package com.sam.SpringWithDTOAndImpl.service;

import java.util.List;

import com.sam.SpringWithDTOAndImpl.dto.EmployeeDto;

public interface EmployeeService {
	
	public EmployeeDto addEmployee(EmployeeDto employeeDto);
	
	public List<EmployeeDto> getAllEmployee();
	
	public EmployeeDto getEmployeeById(Long id) throws Exception;
	
	public EmployeeDto getEmployeeByName(String name) throws Exception;
	
	public EmployeeDto updateEmployee(EmployeeDto employeeDto);
	
	public void deleteEmployeeById(Long id);
}
