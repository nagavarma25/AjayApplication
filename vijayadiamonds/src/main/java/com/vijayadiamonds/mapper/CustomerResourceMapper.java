package com.vijayadiamonds.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.vijayadiamonds.model.Customer;
import com.vijayadiamonds.resource.CustomerResource;

@Service
public class CustomerResourceMapper implements
        Function<Customer, CustomerResource> {

    @Override
    public CustomerResource apply(Customer t) {
        return new CustomerResource(t.getId(), t.getName(), t.getPhoneNumber(),
                t.getAddress(), t.getTransactions());
    }

}
