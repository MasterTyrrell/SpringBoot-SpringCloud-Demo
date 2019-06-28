package com.alan.springboot;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor{

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment,
			SpringApplication arg1) {
		try{
			InputStream is = new FileInputStream("d:/jdbc.properties");
			Properties property = new Properties();
			property.load(is);
			PropertiesPropertySource source = new PropertiesPropertySource("my",property);
			environment.getPropertySources().addLast(source);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
