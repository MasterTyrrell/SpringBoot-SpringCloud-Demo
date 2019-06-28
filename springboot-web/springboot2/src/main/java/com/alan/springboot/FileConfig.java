package com.alan.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySource("classpath:jdbc.properties")
//@PropertySources({@PropertySource("classpath:jdbc.properties"),@PropertySource("classpath:jdbc.properties")})
public class FileConfig {

}
