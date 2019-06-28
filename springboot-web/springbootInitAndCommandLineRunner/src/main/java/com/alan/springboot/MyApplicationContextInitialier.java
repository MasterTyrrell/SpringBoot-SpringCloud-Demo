package com.alan.springboot;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

public class MyApplicationContextInitialier implements
		ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext app) {
		System.out.println("bean count:"+app.getBeanDefinitionCount());
	}

}
