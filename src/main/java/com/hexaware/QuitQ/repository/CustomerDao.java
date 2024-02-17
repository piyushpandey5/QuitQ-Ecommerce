package com.hexaware.QuitQ.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.QuitQ.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer>{

	Optional<Customer> findByMobileNo(String moblieNo);

}
