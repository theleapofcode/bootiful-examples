package com.theleapofcode.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.theleapofcode.springboot.model.Greet;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class BootifulServiceSimpleApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test_greet() {
		ResponseEntity<Greet> greetEntity = this.restTemplate.getForEntity("/", Greet.class);
		Greet greet = greetEntity.getBody();
		Assert.assertEquals("Hello World!", greet.getMessage());
	}

}
