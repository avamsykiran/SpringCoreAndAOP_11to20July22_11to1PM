package com.cts.spring.boot.aop.demo.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.spring.boot.aop.demo.service.GreetService;

@Component
public class AOPDemoUI implements CommandLineRunner {

	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService1;
	
	@Autowired
	@Qualifier("greetServiceAdvancedImpl")
	private GreetService greetService2;
	
	@Autowired
	private Scanner scanner;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Your Name?? ");
		String userName = scanner.next();
		
		System.out.println(greetService1.greet(userName));
		System.out.println(greetService2.greet(userName));
	
	}
}
