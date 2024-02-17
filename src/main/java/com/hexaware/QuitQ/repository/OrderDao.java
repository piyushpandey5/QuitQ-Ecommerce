package com.hexaware.QuitQ.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.QuitQ.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {

}
