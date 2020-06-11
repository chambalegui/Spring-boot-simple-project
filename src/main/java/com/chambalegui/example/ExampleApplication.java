package com.chambalegui.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.chambalegui.example.controller", "com.chambalegui.example.service"})
@EnableJpaRepositories("com.chambalegui.example.dao")
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

}
