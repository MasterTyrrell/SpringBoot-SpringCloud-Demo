	package com.alan.springboot;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

public class MyApplicationContextInitialier2 implements
		ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext app) {
		for(String name:app.getBeanDefinitionNames()){
			System.out.println("beanName:"+name);
		}
	}

}
