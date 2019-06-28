package com.alan.springboot;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@SpringBootConfiguration
public class EncodingConvertConfiguration {

	@Bean
	@Conditional(UTF8Config.class)
	public EncordingConvert createUTF8EncodingConvert(){
		return new Utf8EncordingConvert();
	}
	@Bean
	@Conditional(GBKConfig.class)
	public EncordingConvert createGBKEncodingConvert(){
		return new GBKEncordingConvert();
	}
}
