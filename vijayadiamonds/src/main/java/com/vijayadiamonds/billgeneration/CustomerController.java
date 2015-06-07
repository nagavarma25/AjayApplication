package com.vijayadiamonds.billgeneration;

import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vijayadiamonds.model.Customer;
import com.vijayadiamonds.model.Transaction;
import com.vijayadiamonds.service.CustomerService;

/**
 * @author Janardhan
 *
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

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
	public Customer addCustomer(@RequestBody Customer customer) {
		Objects.requireNonNull(customer.getName(), "Customer name required");
		Objects.requireNonNull(customer.getPhoneNumber(),
				" Customer phone number required");
		Objects.requireNonNull(customer.getAddress(),
				"Customer address required");
		return customerService.addCustomer(customer);

	}

	@RequestMapping(value = "/get", produces = "application/json")
	@ResponseBody
	public Customer getCustomer() {
		System.out.println("get");
		Customer cust = customerService.getCustomer(4L);
		System.out.println(cust.getTransactions().size());
		return cust;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Set<Customer> allCustomers() {
		System.out.println("get");
		return customerService.getAllCustomers();
	}

	@RequestMapping(value = "/{customerId}/transactions", method = RequestMethod.GET)
	@ResponseBody
	public Set<Transaction> getTransactionsForCustomer(
			@PathVariable Long customerId) {
		return customerService.getCustomer(customerId).getTransactions();
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public String loadCustomerTransactionPage() {
		return "customertransactions";
	}
}
