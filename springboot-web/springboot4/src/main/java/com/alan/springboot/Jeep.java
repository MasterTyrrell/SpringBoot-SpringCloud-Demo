package com.alan.springboot;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Jeep implements Runnable {

	@Async
	@Override
	public void run() {
		for(int n =0;n<10;n++){
			System.out.println("-------------"+n);
		}
	}

}
