package ibradi.dev.my_store.service;


import ibradi.dev.my_store.model.Admin;
import ibradi.dev.my_store.model.Customer;
import ibradi.dev.my_store.model.Product;

import java.util.List;

public interface AdminService {
	Admin saveAdmin(Admin admin);

	Admin loginAdmin(Admin admin);

	List<Product> getAllProducts(long adminId);

	List<Customer> getAllCustomers(long adminId);
}