package com.alan.springboot;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
//@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		// TODO Auto-generated method stub
		System.out.println("接受到事件："+event.getClass());
	}

}
