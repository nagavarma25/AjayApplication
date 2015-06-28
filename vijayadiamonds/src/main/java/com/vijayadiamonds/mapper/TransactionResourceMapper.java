package com.vijayadiamonds.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijayadiamonds.model.Sale;
import com.vijayadiamonds.model.Transaction;
import com.vijayadiamonds.resource.ItemResource;
import com.vijayadiamonds.resource.TransactionResource;

@Service
public class TransactionResourceMapper implements
        Function<Transaction, TransactionResource> {
    @Autowired
    private ItemResourceMapper itemResourceMapper;

    @Override
    public TransactionResource apply(Transaction t) {
        List<ItemResource> itemResources = new ArrayList<>();
        Set<Sale> sales = t.getSales();
        for (Sale sale : sales) {
            ItemResource itemResource = itemResourceMapper
                    .apply(sale.getItem());
            itemResource.setSellingPrice(sale.getSellingPrice());
            itemResource.setQuantity(sale.getQuantity());
            itemResources.add(itemResource);
        }
        return new TransactionResource(t.getId(),itemResources, t.getTotalAmount(),
                t.getPaidAmount(), t.getCustomer() , t.getTransactionDate());
    }

}
