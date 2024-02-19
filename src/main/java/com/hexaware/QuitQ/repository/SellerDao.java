package com.hexaware.QuitQ.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.QuitQ.entity.Seller;

@Repository
public interface SellerDao extends JpaRepository<Seller, Integer> {
	Optional<Seller> findByMobileNo(String mobile);
	
}
