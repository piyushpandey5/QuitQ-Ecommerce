package com.hexaware.QuitQ.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.QuitQ.entity.Order;
import com.hexaware.QuitQ.exception.OrderException;

public interface OrderService {
	public List<Order> getAllOrders() throws OrderException;
	public Order getOrderByOrderId(Integer OrderId) throws OrderException;
	public Order cancelOrderByOrderId(Integer OrderId,String token) throws OrderException;
	public List<Order> getAllOrdersByDate(LocalDate date) throws OrderException;
}
