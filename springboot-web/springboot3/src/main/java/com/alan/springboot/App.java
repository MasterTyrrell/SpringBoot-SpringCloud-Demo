package com.alan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class App {
	
	/**
	 * 默认配置文件的名字可以使用 --spring.config.name来指定，只需要填写文件名，不需要拓展名
	 * 制定配置文件的路径可以使用 --spring.config.location来指定，配置文件需要指定全路径，包括目录和文件名字，可以只指定多个，多个用逗号隔开
	 * @param args
	 */
	public static void main(String[] args){
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		System.out.println(System.getProperty("file.encoding"));
		System.out.println(context.getBeansOfType(EncordingConvert.class));
		context.close();
	}
}
