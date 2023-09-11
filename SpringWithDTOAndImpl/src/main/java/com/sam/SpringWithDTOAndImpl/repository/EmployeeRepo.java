package com.sam.SpringWithDTOAndImpl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.SpringWithDTOAndImpl.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	Optional<Employee> findByName(String name);

}
