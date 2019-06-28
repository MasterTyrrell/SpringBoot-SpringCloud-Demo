package com.alan.springboot;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		System.out.println(111111);
		System.out.println(importingClassMetadata.getAnnotationAttributes(EnableLog.class.getName()));
	 	return new String[]{"com.alan.springboot.User",Role.class.getName()};
	}

}
