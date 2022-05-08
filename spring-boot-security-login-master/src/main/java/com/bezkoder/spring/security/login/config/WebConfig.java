package com.bezkoder.spring.security.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Profile("test")
//@Configuration
public class WebConfig implements WebMvcConfigurer {

	//@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowCredentials(true)
				.allowedOrigins("*")
				.allowedHeaders("*")
				.allowedMethods("*")
				.maxAge(3600);
	}

}