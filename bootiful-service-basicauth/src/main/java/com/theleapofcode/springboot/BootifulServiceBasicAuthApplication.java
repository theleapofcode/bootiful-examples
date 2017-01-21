package com.theleapofcode.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity
@SpringBootApplication
public class BootifulServiceBasicAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootifulServiceBasicAuthApplication.class, args);
	}
}
