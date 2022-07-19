package com.cts.spring.boot.aop.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Before("execution(* com.cts.spring.boot.aop.demo.service.*.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		// Advice
		logger.info(" About to invoke execution for {}", joinPoint);
	}

	@After("execution(* com.cts.spring.boot.aop.demo.service.*.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		logger.info(" Done invoking execution for {}", joinPoint);
	}
	
	@AfterReturning("execution(* com.cts.spring.boot.aop.demo.service.*.*(..))")
	public void afterRetruningAdvice(JoinPoint joinPoint) {
		logger.info(" Done returning of execution for {}", joinPoint);
	}
	
	@Around("execution(* com.cts.spring.boot.aop.demo.service.*.*(..))")
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info(" this is before the execution for {}", joinPoint);
		joinPoint.proceed();
		logger.info(" this is after the execution for {}", joinPoint);
	}
}
