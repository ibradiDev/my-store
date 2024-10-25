package ibradi.dev.my_store.servicelmpl;


import ibradi.dev.my_store.exception.ResourceNotFoundException;
import ibradi.dev.my_store.model.Admin;
import ibradi.dev.my_store.model.Customer;
import ibradi.dev.my_store.model.Product;
import ibradi.dev.my_store.repository.AdminRepository;
import ibradi.dev.my_store.repository.CustomerRepository;
import ibradi.dev.my_store.repository.ProductRepository;
import ibradi.dev.my_store.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;

	private CustomerRepository customerRepository;
	private ProductRepository productRepository;


	@Override
	public Admin saveAdmin(Admin admin) {
		System.out.println("admin register service" + admin);

		return adminRepository.save(admin);
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		return this.adminRepository.findByAdminEmailIdAndAdminPassword(admin.adminEmailId, admin.adminPassword).orElseThrow(() -> new ResourceNotFoundException("Admin ", "Id", admin.adminEmailId + "and password " + admin.adminPassword));
	}

	@Override
	public List<Product> getAllProducts(long adminId) {

		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Customer> getAllCustomers(long adminId) {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}


}