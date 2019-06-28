package com.alan.springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConditionalOnClass(Role.class)
public class MyConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public Role createRole(){
		return new Role();
	}
	

}
