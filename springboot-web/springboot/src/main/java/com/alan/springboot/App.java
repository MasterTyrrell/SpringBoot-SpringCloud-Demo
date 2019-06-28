package com.alan.springboot;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
//@EnableAutoConfiguration
//@ComponentScan
public class App {
	
	
	public static void main(String[] args){
//TODO:第一种
//		ConfigurableApplicationContext context = SpringApplication.run(App2.class, args);
		//TODO:第二种
//		SpringApplication app = new SpringApplication(App2.class);
//		ConfigurableApplicationContext context = app.run(App2.class, args);
		//TODO:第三种
		SpringApplication app = new SpringApplication();
		Set<Object> set = new HashSet();
		set.add(App2.class);
		app.setSources(set);
		ConfigurableApplicationContext context = app.run(App2.class, args);
		context.getBean(Runnable.class).run();
		System.out.println(context.getBean(User.class));
	}
}
