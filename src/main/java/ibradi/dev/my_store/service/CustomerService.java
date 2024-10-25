package ibradi.dev.my_store.service;


import ibradi.dev.my_store.model.Customer;

import java.util.List;


public interface CustomerService {
	Customer saveCustomer(Customer customer);

	Customer loginCustomer(Customer customer);

	Customer updateCustomer(Customer customer, long customerId);

	Customer getCustomerById(long customerId);

	List<Customer> getAllCustomers();

	Customer getCustomerByEmail(Customer customer);

	void deleteCustomer(long customerId);

}