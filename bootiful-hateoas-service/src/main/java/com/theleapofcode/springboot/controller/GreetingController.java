package com.theleapofcode.springboot.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.theleapofcode.springboot.model.Greet;

@RestController
public class GreetingController {

	@RequestMapping("/hello")
	Greet hello() {
		return new Greet("Hello World!");
	}

	@RequestMapping("/greeting")
	@ResponseBody
	public HttpEntity<Greet> greeting(
			@RequestParam(value = "name", required = false, defaultValue = "HATEOAS") String name) {
		Greet greet = new Greet("Hello " + name);
		greet.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

		return new ResponseEntity<Greet>(greet, HttpStatus.OK);
	}
}
