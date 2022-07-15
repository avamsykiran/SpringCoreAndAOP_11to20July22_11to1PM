package com.cts.spring.boot.data.jdbc.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.spring.boot.data.jdbc.demo.model.Employee;
import com.cts.spring.boot.data.jdbc.demo.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Transactional
	@Override
	public Employee save(Employee emp) {
		return empRepo.save(emp);
	}

	@Transactional
	@Override
	public void delteById(Long empId) {
		empRepo.deleteById(empId);
	}

	@Override
	public Optional<Employee> findById(Long empId) {
		return empRepo.findById(empId);
	}

	@Override
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

}
