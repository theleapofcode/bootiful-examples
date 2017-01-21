package com.theleapofcode.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theleapofcode.springboot.model.Greet;

@RestController
public class GreetingController {
	@RequestMapping("/")
	Greet greet() {
		return new Greet("Hello World!");
	}
}
