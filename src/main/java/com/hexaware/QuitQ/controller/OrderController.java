package com.hexaware.QuitQ.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.QuitQ.entity.Order;
import com.hexaware.QuitQ.repository.OrderDao;
import com.hexaware.QuitQ.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderDao oDao;
	
	@Autowired
	private OrderService oService;

	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		List<Order> listOfAllOrders = oService.getAllOrders();
		return listOfAllOrders;		
	}
	
	@GetMapping("/orders/{orderId}")
	public Order getOrdersByOrderId(@PathVariable("orderId") Integer orderId) {
		
		return oService.getOrderByOrderId(orderId);
		
	}
	
	@DeleteMapping("/orders/{orderId}")
	public Order cancelTheOrderByOrderId(@PathVariable("orderId") Integer orderId,@RequestHeader("token") String token){
		
		return oService.cancelOrderByOrderId(orderId,token);
	}
	
	@GetMapping("/orders/by/date")
	public List<Order> getOrdersByDate(@RequestParam("date") String date){
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ld=LocalDate.parse(date,dtf);
		return oService.getAllOrdersByDate(ld);
	}
}
