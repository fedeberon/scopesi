package com.ideaas.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ideaas.*")
@EnableAutoConfiguration
public class ScopesiWebApplication extends SpringBootServletInitializer  {

	private static Class<ScopesiWebApplication> applicationClass = ScopesiWebApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(ScopesiWebApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(applicationClass);
	}

}
