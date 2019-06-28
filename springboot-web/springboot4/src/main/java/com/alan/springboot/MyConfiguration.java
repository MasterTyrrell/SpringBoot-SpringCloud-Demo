package com.alan.springboot;

import org.springframework.context.annotation.Bean;

public class MyConfiguration {

	@Bean
	public Runnable createRunnable(){
		return ()->{};
	}
	
	@Bean
	public Runnable createRunnabe2(){
		return ()->{};
	}
}
