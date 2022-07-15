package com.cts.spring.boot.data.jdbc.demo.service;

import java.util.List;
import java.util.Optional;

import com.cts.spring.boot.data.jdbc.demo.model.Employee;

public interface EmployeeService {
	Employee save(Employee emp);
	void delteById(Long empId);
	Optional<Employee> findById(Long empId);
	List<Employee> findAll();
}
