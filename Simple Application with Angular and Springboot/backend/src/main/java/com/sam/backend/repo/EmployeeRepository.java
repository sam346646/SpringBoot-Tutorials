package com.sam.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.backend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
