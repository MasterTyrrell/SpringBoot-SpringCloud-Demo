package com.alan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.alan.diceng.RunnableConfiguration;
//排除配置类
//@EnableAutoConfiguration(exclude=RunnableConfiguration.class)
@EnableAutoConfiguration(excludeName="com.alan.diceng.RunnableConfiguration")
@ComponentScan
public class App {
	
	public static void main(String[] args){
		ConfigurableApplicationContext  context = SpringApplication.run(App.class, args);
		System.out.println(context.getBean(Runnable.class));
		context.close();
	}
}
