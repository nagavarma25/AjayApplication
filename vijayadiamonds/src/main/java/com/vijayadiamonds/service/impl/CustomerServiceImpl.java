package com.vijayadiamonds.service.impl;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijayadiamonds.model.Customer;
import com.vijayadiamonds.repository.CustomerRepository;
import com.vijayadiamonds.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> getCustomer(Long id) {
		return Optional.ofNullable(customerRepository.findOne(id));
	}

	@Override
	public Set<Customer> getAllCustomers() {
		return Collections.unmodifiableSet(customerRepository.findAll());
	}

}
