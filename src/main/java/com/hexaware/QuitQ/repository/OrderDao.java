package com.hexaware.QuitQ.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.QuitQ.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {

	public List<Order> findByOrderDate(LocalDate orderDate);
}
