package com.vijayadiamonds.billgeneration;

import com.vijayadiamonds.exception.ResourceNotFound;
import com.vijayadiamonds.mapper.CustomerResourceMapper;
import com.vijayadiamonds.model.Customer;
import com.vijayadiamonds.model.Transaction;
import com.vijayadiamonds.resource.CustomerResource;
import com.vijayadiamonds.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Janardhan
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerResourceMapper customerResourceMapper;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String loadAddPage() {
		return "addcustomer";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String loadEditPage() {
		return "editcustomer";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public CustomerResource addCustomer(@RequestBody Customer customer) {
		Objects.requireNonNull(customer.getName(), "Customer name required");
		Objects.requireNonNull(customer.getPhoneNumber(),
				" Customer phone number required");
		Objects.requireNonNull(customer.getAddress(),
				"Customer address required");
		return customerResourceMapper.apply(customerService
				.addCustomer(customer));

	}

	@RequestMapping(value = "/{customerId}", produces = "application/json")
	@ResponseBody
	public CustomerResource getCustomer(@PathVariable Long customerId)
			throws ResourceNotFound {
		System.out.println("get");
		Optional<Customer> customer = customerService.getCustomer(customerId);
		customer.orElseThrow(() -> new ResourceNotFound(
				"Unable to find a customer with Id :" + customerId));
		return customerResourceMapper.apply(customer.get());
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Set<CustomerResource> allCustomers() {
		System.out.println("get");
		return customerService.getAllCustomers().stream()
				.map(customerResourceMapper).collect(Collectors.toSet());
	}

	@RequestMapping(value = "/{customerId}/transactions", method = RequestMethod.GET)
	@ResponseBody
	public Set<Transaction> getTransactionsForCustomer(
			@PathVariable Long customerId) throws ResourceNotFound {
		Optional<Customer> customer = customerService.getCustomer(customerId);
		customer.orElseThrow(() -> new ResourceNotFound(
				"Unable to find customer with Id :" + customerId));
		return customer.get().getTransactions();
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public String loadCustomerTransactionPage() {
		return "customertransactions";
	}
}
