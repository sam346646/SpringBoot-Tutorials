package com.user.employee.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.employee.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	Optional<Employee> findEmployeeById(Long id);
}
