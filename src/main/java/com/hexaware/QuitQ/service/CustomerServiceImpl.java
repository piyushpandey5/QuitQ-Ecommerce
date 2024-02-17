package com.hexaware.QuitQ.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.QuitQ.entity.Cart;
import com.hexaware.QuitQ.entity.Customer;
import com.hexaware.QuitQ.repository.CustomerDao;

import jakarta.persistence.criteria.Order;

public class CustomerServiceImpl implements  CustomerService{
	@Autowired
	private CustomerDao customerDao;
	
	
	// Method to add a new customer
	
	@Override
	public Customer addCustomer(Customer customer) {
				
//		customer.setCreatedOn(LocalDateTime.now());
//		
//		Cart c = new Cart();
//		
//		System.out.println(c);
//		
////		System.out.println(c.getProducts().size());
//			
//		customer.setCustomerCart(c);
//		
//		customer.setOrders(new ArrayList<Order>());
//
//		Optional<Customer> existing = customerDao.findByMobileNo(customer.getMobileNo());
////		
////		if(existing.isPresent())
////			throw new CustomerException("Customer already exists. Please try to login with your mobile no");
////		
//		customerDao.save(customer);
		
		return customer;
	}

}
