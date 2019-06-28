package com.alan.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class UserConfig {
	@Value("${local.ip}")
	private String localIp;
	@Value("${local.post}")
	private String localPost;
	@Value("${tomcat.port:8080}")
	private String tomcatPort;
	@Autowired
	private Environment enviroment;
	
	public void show(){
		System.out.println("localIp="+this.localIp);
		System.out.println("localPost="+this.localPost);
		System.out.println("localPort="+this.enviroment.getProperty("local.post"));
		System.out.println("localPort="+this.enviroment.getProperty("local.post",Integer.class));
		System.out.println("tomcatPort="+this.tomcatPort);
		System.out.println("appName="+this.enviroment.getProperty("app.name"));
	}

	public String getLocalIp() {
		return localIp;
	}

	public void setLocalIp(String localIp) {
		this.localIp = localIp;
	}

	public String getLocalPost() {
		return localPost;
	}

	public void setLocalPost(String localPost) {
		this.localPost = localPost;
	}

	public String getTomcatPort() {
		return tomcatPort;
	}

	public void setTomcatPort(String tomcatPort) {
		this.tomcatPort = tomcatPort;
	}

	public Environment getEnviroment() {
		return enviroment;
	}

	public void setEnviroment(Environment enviroment) {
		this.enviroment = enviroment;
	}
	
	
	
}
