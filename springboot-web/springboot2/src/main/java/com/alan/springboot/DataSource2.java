package com.alan.springboot;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("db")
public class DataSource2 {

	private List<String> host;
	
	private List<String> port;

	
	public void show(){
		System.out.println("DataSource2:host="+host+",port="+port);
	}
	
	
	public List<String> getHost() {
		return host;
	}

	public void setHost(List<String> host) {
		this.host = host;
	}

	public List<String> getPort() {
		return port;
	}

	public void setPort(List<String> port) {
		this.port = port;
	}
	
	
}
