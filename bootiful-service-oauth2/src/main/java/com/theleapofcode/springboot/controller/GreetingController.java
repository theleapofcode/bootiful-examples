package com.theleapofcode.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theleapofcode.springboot.model.Greet;

@RestController
public class GreetingController {

	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	@Autowired
	private Environment env;

	@RequestMapping("/")
	Greet greet() {
		logger.info("GreetingController :: greet - bootiful.custom1 = " + env.getProperty("bootiful.custom1"));
		return new Greet("Hello World!");
	}
}
