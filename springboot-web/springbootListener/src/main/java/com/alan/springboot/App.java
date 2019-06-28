package com.alan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//1.自定义事件一般要继承ApplicationEvent抽象类
//2.定义事件监听器,一般是实现ApplicationListener接口
//3.配置监听器需要将监听器加入spring容器中
//4.发布事件	，使用ApplicationContext.publishEvent()
@SpringBootApplication
public class App {
	//配置监听器	
	//1.SpringApplication.addListerner();
//	public static void main(String[] args){
//		SpringApplication app = new SpringApplication(App.class);
//		app.addListeners(new MyApplicationListener());
//		ConfigurableApplicationContext context = app.run(args);
//		context.publishEvent(new MyApplicationEvent(new Object()));
//		context.close();
//	}
	//2.@Component 加载监听器上
//	public static void main(String[] args){
//		SpringApplication app = new SpringApplication(App.class);
//		ConfigurableApplicationContext context = app.run(args);
//		context.publishEvent(new MyApplicationEvent(new Object()));
//		context.close();
//	}
	//3.配置文件中加载监听器
//		public static void main(String[] args){
//			SpringApplication app = new SpringApplication(App.class);
//			ConfigurableApplicationContext context = app.run(args);
//			context.publishEvent(new MyApplicationEvent(new Object()));
//			context.close();
//		}
		//4.自定已eventHandle 使用@EventListener
		public static void main(String[] args){
			SpringApplication app = new SpringApplication(App.class);
			ConfigurableApplicationContext context = app.run(args);
			context.publishEvent(new MyApplicationEvent(new Object()));
			context.stop();
			context.close();
		}
		
}
