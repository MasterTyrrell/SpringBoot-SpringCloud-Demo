package com.alan.springboot;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
		Map<String,Object> map = importingClassMetadata.getAnnotationAttributes(EnableLog.class.getName());
		String[] packages = (String[])map.get("packages");
		List<String> packageList = Arrays.asList(packages);
		BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(EchoBeanPostProcessor.class);
		bdb.addPropertyValue("packages", packageList);
		registry.registerBeanDefinition(EchoBeanPostProcessor.class.getName(), bdb.getBeanDefinition());
		BeanDefinitionBuilder bdb1 = BeanDefinitionBuilder.rootBeanDefinition(User.class);
		registry.registerBeanDefinition(User.class.getName(), bdb1.getBeanDefinition());
	}

}
