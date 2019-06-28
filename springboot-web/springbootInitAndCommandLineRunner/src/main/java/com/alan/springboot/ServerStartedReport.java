package com.alan.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(2)//越小越先执行
@Component
public class ServerStartedReport implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ServerStartedReport.....");

	}

}
