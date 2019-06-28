package com.alan.springboot;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.websocket.WebSocketMessagingAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.alan.springboot.bean.Product;
import com.alan.springboot.mapper.ProductMapper;


@SpringBootApplication
public class App {
	
	public static void main(String[] args) throws SQLException{
//		SpringApplication.run(App.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(App.class,args);
		ProductMapper productMapper =context.getBean(ProductMapper.class);
		Product product = new Product();
		product.setCreateTime(new Date());
		product.setPname("张三");
		product.setType("1112");
		product.setPrice(222.2);
		productMapper.add(product);
		System.out.println(context);
		context.close();
	} 
}
