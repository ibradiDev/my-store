package ibradi.dev.my_store.repository;

import ibradi.dev.my_store.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByEmailIDAndPassword(String emailID, String password);

	Optional<Customer> findByEmailID(String emailID);

}