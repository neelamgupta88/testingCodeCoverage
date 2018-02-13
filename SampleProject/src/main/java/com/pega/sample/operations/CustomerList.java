package com.pega.sample.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.pega.sample.users.Customer;

public class CustomerList {
	
	private List<Customer> customers;
	
	public CustomerList() {
		customers = new ArrayList<>();
	}
	
	public void addCustomer(Customer customer) {
		customer.setId(UUID.randomUUID().toString());
		customers.add(customer);
	}
	
	public boolean deleteCustomer(String id) {
		Optional<Customer> customerInfo = customers.stream().filter(customer -> customer.getId().equals(id)).findFirst();
		if(customerInfo.isPresent()) {
			customers.remove(customerInfo.get());
			return true;
		} else {
			return false;
		}
	}

}
