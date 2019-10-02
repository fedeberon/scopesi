package com.ideaas.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.ideaas.*")
@SpringBootApplication
public class ScopesiWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScopesiWebApplication.class, args);
	}
}
