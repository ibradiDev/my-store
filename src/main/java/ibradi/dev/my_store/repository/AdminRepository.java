package ibradi.dev.my_store.repository;


import ibradi.dev.my_store.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Optional<Admin> findByAdminEmailIdAndAdminPassword(String emailId, String password);
}