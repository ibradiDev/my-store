package ibradi.dev.my_store.controller;


import ibradi.dev.my_store.model.Admin;
import ibradi.dev.my_store.service.AdminService;
import ibradi.dev.my_store.service.CustomerService;
import ibradi.dev.my_store.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")

@AllArgsConstructor
@Builder
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	private AdminService adminservice;
	private ProductService productService;
	private CustomerService customerService;

	// admin register
	@PostMapping("/register")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) {
		System.out.println("admin register " + admin);
		return new ResponseEntity<Admin>(adminservice.saveAdmin(admin), HttpStatus.CREATED);
	}

	// admin login
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminservice.loginAdmin(admin), HttpStatus.OK);

	}


}