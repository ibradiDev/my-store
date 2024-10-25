package ibradi.dev.my_store.repository;


import ibradi.dev.my_store.model.Category;
import ibradi.dev.my_store.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {
	public List<Product> findByProductId(long productId);

	//public Product updateProduct(long ProductId);
	public List<Product> findByCategory(Category category);

	public Page<Product> findByCategory(Category category, Pageable page);

}