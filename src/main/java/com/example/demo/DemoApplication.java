package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

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

	@Bean
	public ResourceBundleMessageSource resourceBundleMessageSource() {
		ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
		rs.setDefaultLocale(new Locale("no"));
		rs.setBasename("error-messages");
		rs.setDefaultEncoding("UTF-8");
		rs.setUseCodeAsDefaultMessage(true);

		return rs;
	}
	@Bean
	public LocaleResolver localResolver() {
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("no"));
		return localeResolver;

	}

}
