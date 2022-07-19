package com.cts.spring.boot.aop.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopDemoApplication.class, args);
	}
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}