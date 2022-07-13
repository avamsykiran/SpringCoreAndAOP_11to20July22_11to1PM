package com.cts.spring.ioc.demo.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceMultilingualImpl implements GreetService {
 
	@Value("${greeting.array}")
	private String[] greetings;
	
	@Override
	public String greet(String userName) {
		return Arrays.stream(greetings).map(g -> String.format("%s %s", g,userName)).reduce((g1,g2)->g1+"\n"+g2).orElse(null);
	}

}
