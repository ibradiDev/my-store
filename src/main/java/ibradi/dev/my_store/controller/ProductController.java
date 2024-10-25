package ibradi.dev.my_store.controller;


import ibradi.dev.my_store.model.Category;
import ibradi.dev.my_store.model.Product;
import ibradi.dev.my_store.model.ProductPaging;
import ibradi.dev.my_store.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;


	//to add product to cart
	@PostMapping("/add products")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {

		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.CREATED);
	}

	// to get all products
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// to get product by cart id
	@GetMapping("products/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") long productId) {
		return new ResponseEntity<Product>(productService.getProductByProductId(productId), HttpStatus.OK);
	}

	// to update product
	@PutMapping("{productId}")
	public ResponseEntity<Product> updateProduct(@Valid @PathVariable("productId") long productId, @RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(product, productId), HttpStatus.OK);
	}

	@DeleteMapping("{productId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable("productId") long productId) {
		productService.deleteProduct(productId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}

	@GetMapping("/{categoryId}")
	public List<Product> getAllProductsByCategory(@PathVariable("categoryId") int categoryId) {
		Category c = Category.valueOf(categoryId);
		return productService.findByCategory(c);
	}

	@GetMapping("/{categoryId}/{pageNo}/{pageSize}")
	public ProductPaging getAllProductsByCategory(@PathVariable("categoryId") int categoryId, @PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
		Category c = Category.valueOf(categoryId);
		return productService.findByCategory(c, pageNo, pageSize);
	}

	@GetMapping("/{pageNo}/{pageSize}")
	public ProductPaging getAllProducts(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
		return productService.getAllProducts(pageNo, pageSize);
	}

}