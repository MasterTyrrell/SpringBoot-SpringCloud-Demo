package com.alan.diceng;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunnableConfiguration {
	@Bean
	public Runnable createRunnable(){
		return ()->{};
	}
}
