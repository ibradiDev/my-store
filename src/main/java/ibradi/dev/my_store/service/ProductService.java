package ibradi.dev.my_store.service;


import ibradi.dev.my_store.model.Category;
import ibradi.dev.my_store.model.Product;
import ibradi.dev.my_store.model.ProductPaging;

import java.util.List;

public interface ProductService {
	Product addProduct(Product product);

	List<Product> getAllProducts();

	Product getProductByProductId(long productId);

	Product updateProduct(Product product, long productId);

	void deleteProduct(long productId);

	List<Product> findByCategory(Category category);

	ProductPaging findByCategory(Category category, Integer pageNo, Integer pageSize);

	ProductPaging getAllProducts(Integer pageNo, Integer pageSize);
}