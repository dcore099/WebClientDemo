package com.example.webClientDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class WebClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebClientDemoApplication.class, args);
	}

}
