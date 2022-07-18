package com.cts.spring.boot.data.jdbc.demo.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cts.spring.boot.data.jdbc.demo.model.Employee;
import com.cts.spring.boot.data.jdbc.demo.repo.EmployeeRepo;
import com.cts.spring.boot.data.jdbc.demo.service.EmployeeService;

@Component
public class EmployeeUI implements ApplicationRunner {

	@Autowired
	private EmployeeService empService;
	@Autowired
	private Scanner kbin;
	@Autowired
	private DateTimeFormatter dtf;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Menu menu =null;
		Menu[] menus = Menu.values();
		
		while(menu!=Menu.QUIT) {
			Arrays.stream(menus).map(m -> m.ordinal() +"\t"+m).forEach(System.out::println);
			System.out.print("Choice: ");
			int ch = kbin.nextInt();
			
			if(ch<0 || ch>=menus.length) {
				System.out.println("Invalid choice");
				continue;
			}
			menu = menus[ch];
			switch(menu) {
			case LIST:doList();break;
			case ADD:doAdd(); break;
			case REMOVE:doRemove(); break;
			case QUIT: System.out.println("App Terminated"); break;
			}
		}
	}

	private void doList() {
		List<Employee> emps = empService.findAll();
		
		if(emps.isEmpty()) {
			System.out.println("No records");
		}else {
			emps.stream().forEach(System.out::println);
		}
	}
	
	private void doAdd() {
		Employee emp = new Employee();
		
		System.out.print("Name: ");
		emp.setFullName(kbin.next());
		System.out.print("BasicPay: ");
		emp.setBasic(kbin.nextDouble());
		System.out.print("JoinDate{dd-MM-yy): ");
		emp.setJoinDate(LocalDate.parse(kbin.next(), dtf));
		
		emp = empService.save(emp);
		System.out.println("Employee added with id: "+emp.getEmpId());
		
	}
	
	private void doRemove() {
		System.out.println("EmpId: ");
		long empId = kbin.nextLong();
		
		empService.delteById(empId);
		System.out.println("Employee Deleted");
	}
}
