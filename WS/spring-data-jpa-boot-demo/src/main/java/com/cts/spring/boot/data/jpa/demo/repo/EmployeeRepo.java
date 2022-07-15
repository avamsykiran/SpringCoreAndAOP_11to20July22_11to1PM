package com.cts.spring.boot.data.jpa.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.spring.boot.data.jpa.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
	
}
