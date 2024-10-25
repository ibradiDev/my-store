package ibradi.dev.my_store.repository;

import ibradi.dev.my_store.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
		public List<Payment> findByOrderId(long orderId);
}