package com.vijayadiamonds.service;

import java.util.Set;

import com.vijayadiamonds.model.Customer;

public interface CustomerService {

	Customer addCustomer(Customer customer);
	Customer getCustomer(Long id);
	
	Set<Customer> getAllCustomers();
}
