package com.alan.springboot;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootConfiguration
public class MyConfig {
	@Bean
	public Runnable createRunnable(){
		System.out.println("=====1=======");
		return ()->{};
	}
	@Bean
	@Profile("test")
	public Runnable createRunnable2(){
		System.out.println("=====2=======");
		return ()->{System.out.println("=====2=======");};
	}
	@Bean
	@Profile("dev")
	public Runnable createRunnable3(){
		System.out.println("=====3=======");
		return ()->{System.out.println("=====3=======");};
	}
}
