package com.alan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration
@ComponentScan
@EnableLog(packages={"123124","2131243242"})
public class App {
	
	public static void main(String[] args){
		ConfigurableApplicationContext  context = SpringApplication.run(App.class, args);
		System.out.println(context.getBean(User.class));
		context.close();
	}
}
