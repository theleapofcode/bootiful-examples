package com.theleapofcode.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.theleapofcode.springboot.entity.Customer;
import com.theleapofcode.springboot.repository.CustomerRepository;

@SpringBootApplication
public class BootifulCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootifulCustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CustomerRepository customerRepository) {
		return (evt) -> {
			customerRepository.save(new Customer("Tony", "tony@avengers.com"));
			customerRepository.save(new Customer("Steve", "steve@avengers.com"));
			customerRepository.save(new Customer("Thor", "thor@avengers.com"));
			customerRepository.save(new Customer("Bruce", "bruce@avengers.com"));
			customerRepository.save(new Customer("Clint", "clint@avengers.com"));
			customerRepository.save(new Customer("Natasha", "natasha@avengers.com"));
		};
	}
}
