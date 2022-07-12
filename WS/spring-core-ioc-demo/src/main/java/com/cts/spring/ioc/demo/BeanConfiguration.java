package com.cts.spring.ioc.demo;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cts.spring.ioc.demo")
@PropertySource("classpath:app.properties")
public class BeanConfiguration {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public LocalDate today() {
		return LocalDate.now();
	}
}