package com.hexaware.QuitQ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.QuitQ.entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart,Integer>{

}
