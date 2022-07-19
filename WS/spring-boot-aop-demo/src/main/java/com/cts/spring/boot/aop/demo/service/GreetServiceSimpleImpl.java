package com.cts.spring.boot.aop.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceSimpleImpl implements GreetService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public String greet(String userName) {
		logger.info("Done executing 'greet' returning the value");
		return "Hello " + userName;
	}

}
