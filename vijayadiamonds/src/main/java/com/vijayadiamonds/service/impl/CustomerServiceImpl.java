package com.vijayadiamonds.service.impl;

import com.vijayadiamonds.model.Customer;
import com.vijayadiamonds.repository.CustomerRepository;
import com.vijayadiamonds.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Set<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
