package com.alan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
//@ServletComponentScan
@SpringBootApplication(exclude=ErrorMvcAutoConfiguration.class)
public class App {
	
	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}
