package com.vijayadiamonds.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.vijayadiamonds.model.Transaction;
import com.vijayadiamonds.resource.TransactionResource;

@Service
public class TransactionResourceMapper implements
        Function<Transaction, TransactionResource> {

    @Override
    public TransactionResource apply(Transaction t) {

        return new TransactionResource(null, t.getTotalAmount(),
                t.getPaidAmount(), t.getCustomer());
    }

}
