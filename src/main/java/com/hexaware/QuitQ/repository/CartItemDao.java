package com.hexaware.QuitQ.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.QuitQ.entity.CartItem;

@Repository
public interface CartItemDao extends JpaRepository<CartItem,Integer>{

}
