package com.alan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
//@ServletComponentScan
@SpringBootApplication
public class App {
	
	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}
