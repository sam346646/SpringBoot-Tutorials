package com.sam.SpringWithDTOAndImpl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.SpringWithDTOAndImpl.dto.EmployeeDto;
import com.sam.SpringWithDTOAndImpl.model.Employee;
import com.sam.SpringWithDTOAndImpl.repository.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee convertDtoToModel(EmployeeDto employeeDto) {
		Employee employee = new Employee();

		employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setDept(employeeDto.getDept());

		return employee;
	}

	public EmployeeDto convertModelToDto(Employee employee) {
		return new EmployeeDto(employee);
	}

	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		Employee employee = convertDtoToModel(employeeDto);
		return convertModelToDto(employeeRepo.save(employee));
	}

	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees = employeeRepo.findAll();
		List<EmployeeDto> employeesDto = new ArrayList<>();

		for (Employee employee : employees) {
			employeesDto.add(convertModelToDto(employee));
		}

		return employeesDto;
	}

	public EmployeeDto getEmployeeById(Long id) throws Exception {
		Employee employee = employeeRepo.findById(id).orElseThrow(() -> new Exception("Id not found"));
		return convertModelToDto(employee);
	}

	public EmployeeDto getEmployeeByName(String name) throws Exception{
		Employee employee = employeeRepo.findByName(name).orElseThrow(() -> new Exception("Name not found"));
		return convertModelToDto(employee);
	}

	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		Employee employee = convertDtoToModel(employeeDto);
		return convertModelToDto(employeeRepo.save(employee)) ;
	}

	public void deleteEmployeeById(Long id) {
		employeeRepo.deleteById(id);
	}
}
