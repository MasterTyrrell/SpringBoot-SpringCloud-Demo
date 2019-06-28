package com.alan.springboot;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
//	private final static Logger log = Logger.getLogger(UserDao.class);
	private final static Logger log = LoggerFactory.getLogger(UserDao.class);
	public void log(){
		log.debug("log debug 112321");
		log.info("log info 112321");
		log.warn("log warn 112321");
		log.error("log error 112321");
	
	}
}
