package com.sam.SpringWithDTOAndImpl.dto;

import com.sam.SpringWithDTOAndImpl.model.Employee;

public class EmployeeDto {
	
	private Long id;
	private String name;
	private String dept;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	public EmployeeDto() {
	}
	public EmployeeDto(Employee employee) {
		this.id=employee.getId();
		this.name=employee.getName();
		this.dept=employee.getDept();
	}
}
