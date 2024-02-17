package com.hexaware.QuitQ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.QuitQ.entity.Address;

@Repository
public interface AddressDao extends JpaRepository<Address,Integer>{
	
}
