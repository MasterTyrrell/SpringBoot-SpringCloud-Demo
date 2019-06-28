package com.alan.springboot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class App2 {
	@Bean
	public Runnable createRunnable(){
		return ()->{System.out.println("Springboot start");};
	}
}
