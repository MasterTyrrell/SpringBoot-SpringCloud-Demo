package com.alan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//CommandLineRunner是spring容器启动后最后一步的回调
//CommandLineRunner与ApplicationRunner的qubie 
//CommandLineRunner是原始参数
//AppicationRunner对原始参数进行了处理和封装
@SpringBootApplication
public class App {
		public static void main(String[] args){
			SpringApplication app = new SpringApplication(App.class);
//			app.addInitializers(new MyApplicationContextInitialier());
			ConfigurableApplicationContext context = app.run("aa","bb");
			context.stop();
			context.close();
		}
}
