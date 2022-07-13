package com.cts.spring.ioc.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceSimpleImpl implements GreetService {

	@Override
	public String greet(String userName) {
		return String.format("Hello %s", userName);
	}

}
