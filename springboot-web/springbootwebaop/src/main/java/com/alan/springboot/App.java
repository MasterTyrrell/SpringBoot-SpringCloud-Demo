package com.alan.springboot;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@ServletComponentScan
@SpringBootApplication
//启动对事务注解
@EnableTransactionManagement
public class App {
	
	public static void main(String[] args) throws SQLException{
//		SpringApplication.run(App.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(App.class,args);
		DataSource ds = context.getBean(DataSource.class);
		System.out.println(ds.getClass());
		Connection con = ds.getConnection(); 
		System.out.println(con.getCatalog());
		con.close();
//		context.getBean(UserDao.class).addUser();
	
	}
}
