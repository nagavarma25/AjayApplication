package com.vijayadiamonds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijayadiamonds.model.Sale;
import com.vijayadiamonds.repository.SaleRepository;
import com.vijayadiamonds.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepository saleRepository;

	@Override
	public Sale addSale(Sale sale) {
		return saleRepository.save(sale);
	}

}
