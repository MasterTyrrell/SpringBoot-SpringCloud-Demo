package com.alan.springboot;

import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandle {
	//对相应的事件监听
	@EventListener
	public void event(MyApplicationEvent event){
		System.out.println("MyEventHandle接受到事件"+event.getClass());
	}
	//对所有事件做监听
//	@EventListener
//	public void event(Object event){
//		System.out.println("MyEventHandle接受到事件"+event.getClass());
//	}
	@EventListener
	public void event2(ContextStoppedEvent event){
		System.out.println("MyEventHandle接受到事件"+event.getClass());
	}
}
