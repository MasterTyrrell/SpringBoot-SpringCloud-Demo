package com.alan.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserConfiguration {

	@Bean
	@ConditionalOnProperty(name="runnable.enabled",havingValue="true",matchIfMissing=true)
	public Runnable createRunnable(){
		return ()->{};
	}
	
	@Bean
	@ConditionalOnClass(name="org.springframework.boot")
	public Runnable createGsonRunnable(){
		return ()->{};
	}
	@Bean
	@ConditionalOnBean(name="runnable.enabled")
	public Runnable createBeanRunnable(){
		return ()->{};
	}
}
