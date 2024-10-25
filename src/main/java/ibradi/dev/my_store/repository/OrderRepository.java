package ibradi.dev.my_store.repository;

import ibradi.dev.my_store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findByCustomerCustomerId(long customerId);

	//public List<Order> findByCartId(long cartId);
	public void deleteByOrderId(long orderId);
}