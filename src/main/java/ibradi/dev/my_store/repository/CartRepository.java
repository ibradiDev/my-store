package ibradi.dev.my_store.repository;


import ibradi.dev.my_store.model.Cart;
import ibradi.dev.my_store.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	void deleteCartByCustomer(Customer c);
}