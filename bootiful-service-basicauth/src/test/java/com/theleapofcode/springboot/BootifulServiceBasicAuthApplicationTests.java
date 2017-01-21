package com.theleapofcode.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.junit4.SpringRunner;

import com.theleapofcode.springboot.model.Greet;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class BootifulServiceBasicAuthApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGreet() {
		String plainCreds = "user:user";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + new String(Base64.encode(plainCreds.getBytes())));
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<Greet> greetEntity = this.restTemplate.exchange("/", HttpMethod.GET, request, Greet.class);
		Greet greet = greetEntity.getBody();
		Assert.assertEquals("Hello World!", greet.getMessage());
	}

}
