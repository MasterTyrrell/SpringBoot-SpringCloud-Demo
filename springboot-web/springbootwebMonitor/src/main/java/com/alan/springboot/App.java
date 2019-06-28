package com.alan.springboot;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.websocket.WebSocketMessagingAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication(exclude=WebSocketMessagingAutoConfiguration.class)
@PropertySource("my.properties")
public class App {
	
	public static void main(String[] args) throws SQLException{
//		SpringApplication.run(App.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(App.class,args);
		System.out.println(context);
	} 
}
