package ibradi.dev.my_store.controller;


import ibradi.dev.my_store.model.Customer;
import ibradi.dev.my_store.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Builder
@CrossOrigin(origins = "http://localhost:4200")

@RestController // is controller which provides different end points to access the services
@RequestMapping("/api/customers")
public class CustomerController {

	private CustomerService customerService;


	//Register
	//http://localhost:8084/register
	@PostMapping("/register")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {

		return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
	}

	//Login
	@PostMapping("/login")
	public ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<Customer>(customerService.loginCustomer(customer), HttpStatus.OK);

	}

	//Update Customer
	@PutMapping("customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long customerId, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, customerId), HttpStatus.OK);
	}

	//Get All Customer
	@GetMapping()
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	// get customer by email
	@PostMapping("/forgotpassword")
	public Customer getCustomerByEmail(@RequestBody Customer customer) {
		return customerService.getCustomerByEmail(customer);
	}

	// get customer by id
	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerId) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	//Delete Customer
	@DeleteMapping("customer/{id}")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable("id") long customerId) {
		customerService.deleteCustomer(customerId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}

	@PostMapping("/{cid}/{newpassword}")
	public Customer changeCustomerPassword(@PathVariable("cid") long cid, @PathVariable("newpassword") String newpassword) {
		//return customerService.getCustomerByEmail(customer);
		Customer c = customerService.getCustomerById(cid);
		c.setPassword(newpassword);
		customerService.updateCustomer(c, cid);
		return c;
	}
}