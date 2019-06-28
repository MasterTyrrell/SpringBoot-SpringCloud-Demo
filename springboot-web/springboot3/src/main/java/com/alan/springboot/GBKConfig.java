package com.alan.springboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class GBKConfig implements Condition {

	@Override
	public boolean matches(ConditionContext arg0, AnnotatedTypeMetadata arg1) {
		String encoding  = System.getProperty("file.encoding");
		if(encoding!=null){
			return "gbk".equals(encoding.toLowerCase());
		}
		return false;
	}

}
