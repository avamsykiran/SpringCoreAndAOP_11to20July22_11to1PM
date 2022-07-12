package com.cts.spring.ioc.demo.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.spring.ioc.demo.service.GreetService;

@Component
public class HomeUI {
	
	@Value("${app.title:My First Spring App}")
	private String appTitle;
	
	@Autowired
	private Scanner scan;
	
	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService1;
	
	@Autowired
	@Qualifier("greetServiceAdvancedImpl")
	private GreetService greetService2;
	
	public void run() {
		System.out.println(appTitle);
		
		System.out.print("Your Name: ");
		String userName = scan.nextLine();
		
		System.out.println(greetService1.greet(userName));
		System.out.println(greetService2.greet(userName));
	}
}
