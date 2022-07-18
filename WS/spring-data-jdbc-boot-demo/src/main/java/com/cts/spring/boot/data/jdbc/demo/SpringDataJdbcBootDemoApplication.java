package com.cts.spring.boot.data.jdbc.demo;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJdbcBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcBootDemoApplication.class, args);
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	public DateTimeFormatter dateTimeFormatter() {
		return DateTimeFormatter.ofPattern("dd-MM-yy");
	}
}
