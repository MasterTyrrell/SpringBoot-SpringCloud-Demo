package com.alan.springboot;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	@Before("execution(* com.alan.springboot.dao..*.*(..))")
	public void beforeAspect(){
		System.out.println("before dao........."+AopContext.currentProxy());
	}
	@After("execution(* com.alan.springboot.dao..*.*(..))")
	public void afterAspect(JoinPoint point){
		System.out.println("after dao........."+point.getTarget().getClass()+",args:"+Arrays.asList(point.getArgs()));
	}
}
