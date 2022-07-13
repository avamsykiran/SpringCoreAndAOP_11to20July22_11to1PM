package com.cts.spring.ioc.demo.ui;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.spring.ioc.demo.service.Counter;
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

	@Autowired
	@Qualifier("greetServiceMultilingualImpl")
	private GreetService greetService3;

	@Autowired
	@Qualifier("greetServiceMultilingualImpl2")
	private GreetService greetService4;

	@Autowired
	private Counter c1;
	
	@Autowired
	private Counter c2;
	
	@Autowired
	private Counter c3;
	
	public HomeUI() {
		System.out.println("HoemUI object is constructed");
		System.out.println(appTitle);
		System.out.println(greetService1);
		System.out.println(greetService2);
		System.out.println(greetService3);
		System.out.println(greetService4);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("HoemUI bean is initiated");
		System.out.println(appTitle);
		System.out.println(greetService1);
		System.out.println(greetService2);
		System.out.println(greetService3);
		System.out.println(greetService4);
	}
	
	public void run() {
		System.out.println(appTitle);

		System.out.print("Your Name: ");
		String userName = scan.nextLine();

		System.out.println(greetService1.greet(userName));
		System.out.println(greetService2.greet(userName));
		System.out.println(greetService3.greet(userName));
		System.out.println(greetService4.greet(userName));
		
		System.out.println(c1.next());
		System.out.println(c2.next());
		System.out.println(c3.next());
	}
}
