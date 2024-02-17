package com.hexaware.QuitQ.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.QuitQ.entity.Seller;

@Repository
public interface SellerDao extends JpaRepository<Seller, Integer> {
	 @Query("SELECT s FROM Seller s WHERE s.sellerId = ?1")
	Seller findById(long sellerId);
	Optional<Seller> findByMobileNo(String mobileNo);
	
}
