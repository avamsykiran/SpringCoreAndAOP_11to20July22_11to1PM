package com.cts.spring.boot.data.jdbc.demo.repo;

import java.util.List;
import java.util.Optional;

import com.cts.spring.boot.data.jdbc.demo.model.Employee;

public interface EmployeeRepo {
	Employee save(Employee emp);
	void deleteById(Long empId);
	Optional<Employee> findById(Long empId);
	List<Employee> findAll();
}
