package com.alan.springboot;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegister implements
		ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(
			AnnotationMetadata importingClassMetadata,
			BeanDefinitionRegistry registry) {
		BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(Right.class);
		BeanDefinition beanDefinition = bdb.getBeanDefinition();
		registry.registerBeanDefinition("right", beanDefinition);
	}

}
