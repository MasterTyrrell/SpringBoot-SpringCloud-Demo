package com.alan.springboot;
import java.sql.SQLException;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;


public class App {
	
	public static void main(String[] args) throws SQLException{
		RestTemplate rt=new RestTemplate();
		String body = rt.getForObject("http://127.0.0.1:8080/soa/product/1", String.class);
		Response res= new Gson().fromJson(body,Response.class);
	} 
}
