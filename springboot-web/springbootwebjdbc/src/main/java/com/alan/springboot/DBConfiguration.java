package com.alan.springboot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@SpringBootConfiguration
public class DBConfiguration {
	@Autowired
	Environment ev;
	@Bean
	public DataSource createDataSource(){
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl(ev.getProperty("spring.datasource.url"));
		ds.setUsername(ev.getProperty("spring.datasource.username"));
		ds.setPassword(ev.getProperty("spring.datasource.password"));
		ds.setDriverClassName(ev.getProperty("spring.datasource.driverClassName"));
		ds.setDbType(ev.getProperty("spring.datasource.type"));
		return ds;
	}
}
