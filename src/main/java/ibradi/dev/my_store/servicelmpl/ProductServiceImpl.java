package ibradi.dev.my_store.servicelmpl;


import ibradi.dev.my_store.exception.ResourceNotFoundException;
import ibradi.dev.my_store.model.Category;
import ibradi.dev.my_store.model.Product;
import ibradi.dev.my_store.model.ProductPaging;
import ibradi.dev.my_store.repository.ProductRepository;
import ibradi.dev.my_store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepository;


	@Override
	public Product addProduct(Product product) {
		System.out.println("Product added Succesfully " + product);
		product.setProductname(product.getProductname());
		product.setQuantity(product.getQuantity());
		product.setMrpPrice(product.getMrpPrice());
		product.setDescription(product.getDescription());
		return productRepository.save(product);
	}


	@Override
	public Product updateProduct(Product product, long productId) {

		Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("product", "productId", productId));
		existingProduct.setProductname(product.getProductname());
		//existingProduct.setPrice(product.getPrice());
		existingProduct.setMrpPrice(product.getMrpPrice());
		existingProduct.setImage(product.getImage());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setQuantity(product.getQuantity());
		//existingProduct.setCartId(product.getCartId());

		productRepository.save(existingProduct);

		return existingProduct;

	}

	@Override
	public void deleteProduct(long productId) {
		productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("product", "Id", productId));
		productRepository.deleteById(productId);


	}


	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}


	@Override
	public Product getProductByProductId(long productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
	}

	@Override
	public List<Product> findByCategory(Category catgory) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(catgory);
		//return productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product","Id",productId));
	}

	@Override
	public ProductPaging findByCategory(Category catgory, Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pageResult = productRepository.findByCategory(catgory, paging);
		ProductPaging pr = new ProductPaging();
		pr.setTotalProduct(pageResult.getTotalElements());
		if (pageResult.hasContent()) {
			pr.setProduct(pageResult.getContent());
		} else {
			pr.setProduct(new ArrayList<Product>());
		}
		return pr;
	}

	@Override
	public ProductPaging getAllProducts(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pageResult = productRepository.findAll(paging);
		ProductPaging pr = new ProductPaging();
		pr.setTotalProduct(pageResult.getTotalElements());
		System.out.println(">>>>>" + pageResult.getTotalPages());
		if (pageResult.hasContent()) {
			pr.setProduct(pageResult.getContent());
		} else {
			pr.setProduct(new ArrayList<>());
		}
		return pr;
	}
}