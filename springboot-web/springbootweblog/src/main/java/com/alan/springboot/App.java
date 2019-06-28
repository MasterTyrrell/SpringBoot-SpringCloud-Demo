package com.alan.springboot;


import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;


//@ServletComponentScan
@SpringBootApplication(exclude=WebSocketAutoConfiguration.class)
public class App {
	
	public static void main(String[] args) throws SQLException{
//		SpringApplication.run(App.class, args);
//		ConfigurableApplicationContext context = SpringApplication.run(App.class,"--debug");
		ConfigurableApplicationContext context = SpringApplication.run(App.class,args);
		context.getBean(UserDao.class).log();
		context.close();
	}
}
