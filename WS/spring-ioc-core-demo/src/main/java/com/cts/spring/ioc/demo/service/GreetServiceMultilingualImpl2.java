package com.cts.spring.ioc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceMultilingualImpl2 implements GreetService {
 
	@Value("#{${greeting.list}}")
	private List<String> greetings;
	
	@Override
	public String greet(String userName) {
		return greetings.stream().map(g -> String.format("%s %s", g,userName)).reduce((g1,g2)->g1+"\n"+g2).orElse(null);
	}

}
