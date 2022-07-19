package com.cts.spring.boot.aop.demo.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceAdvancedImpl implements GreetService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public String greet(String userName) {
		String greetNote = "";
		
		int h = LocalDateTime.now().getHour();
		
		if(h>=4 && h<=11) greetNote="Good Morning";
		else if(h>=12 && h<=16) greetNote="Good Noon";
		else greetNote="Good Evening";
		
		logger.info("Done executing 'greet' returning the value");
		
		return greetNote + " "+userName;
	}

}
