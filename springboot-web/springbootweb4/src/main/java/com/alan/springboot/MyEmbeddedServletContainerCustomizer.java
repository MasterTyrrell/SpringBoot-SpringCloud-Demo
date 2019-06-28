package com.alan.springboot;

import java.io.File;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.AccessLogValve;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
@Component
public class MyEmbeddedServletContainerCustomizer implements
		EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
//			System.out.println(container.getClass());
		TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory)container;
		factory.setPort(10001);
		factory.setBaseDirectory(new File("d:/emp/tomcat"));
		factory.addContextValves(getLogAccessLogValue());
		factory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
		factory.addInitializers((servletContext)->{
			System.out.println("-------初始化--------");
			servletContext.setAttribute("startup", "true");
		});
	}

	private AccessLogValve getLogAccessLogValue() {
		AccessLogValve log = new AccessLogValve();
		log.setDirectory("e:/tmp/tomcat");
		log.setEnabled(true);
		log.setPattern("common");
		log.setPrefix("springboot-access-log");
		log.setSuffix(".txt");
		return log;
	}
	
	class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer{

		@Override
		public void customize(Connector connector) {
			Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
			protocol.setMaxConnections(2000);
			protocol.setMaxThreads(20);
			
		}
		
	}
	
	
}
