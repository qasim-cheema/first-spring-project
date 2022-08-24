package com.example.demo;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.domain.Example;
@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication
public class DemoApplication {
	static Logger logger= LogManager.getLogger(DemoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
     logger.trace("This is tracing message");
	 logger.debug("This is debuging message");
	 logger.info("This is Info");
	 logger.warn("This is warning");
	}

}
