package com.alan.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="tomcat")
public class TomcatProrperties {
	private String host;
	private Integer port;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	@Override
	public String toString() {
		return "TomcatProrperties [host=" + host + ", port=" + port + "]";
	}
	

}
