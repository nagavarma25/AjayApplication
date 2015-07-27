package com.vijayadiamonds.service;

import com.vijayadiamonds.model.Customer;

import java.util.Optional;
import java.util.Set;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    Optional<Customer> getCustomer(Long id);

    Set<Customer> getAllCustomers();
}
