package com.alan.springboot;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EchoBeanPostProcessor implements BeanPostProcessor {

	private List<String> packages;
	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1)
			throws BeansException {
		for(String str:packages){
			System.out.println(str);
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}
	
	

}
