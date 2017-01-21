package com.theleapofcode.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.theleapofcode.springboot.entity.Customer;
import com.theleapofcode.springboot.messaging.Sender;
import com.theleapofcode.springboot.repository.CustomerRepository;

@Component
@Lazy
public class CustomerRegistrar {

	private CustomerRepository customerRepository;
	Sender sender;

	@Autowired
	CustomerRegistrar(CustomerRepository customerRepository, Sender sender) {
		this.customerRepository = customerRepository;
		this.sender = sender;
	}

	Customer register(Customer customer) {
		Optional<Customer> existingCustomer = customerRepository.findByName(customer.getName());
		if (existingCustomer.isPresent()) {
			throw new RuntimeException("is already exists");
		} else {
			customerRepository.save(customer);
			sender.send(customer.getEmail());
		}
		return customer;
	}
}
