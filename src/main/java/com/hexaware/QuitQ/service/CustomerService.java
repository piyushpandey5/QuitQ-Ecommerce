package com.hexaware.QuitQ.service;

import java.util.List;

import com.hexaware.QuitQ.DTO.CustomerDTO;
import com.hexaware.QuitQ.DTO.CustomerUpdateDTO;
import com.hexaware.QuitQ.DTO.SessionDTO;
import com.hexaware.QuitQ.entity.Address;
import com.hexaware.QuitQ.entity.Customer;
import com.hexaware.QuitQ.entity.Order;
import com.hexaware.QuitQ.exception.CustomerException;
import com.hexaware.QuitQ.exception.CustomerNotFoundException;

public interface CustomerService {
	public Customer addCustomer(Customer customer);

	public List<Customer> getAllCustomers(String token);

	public Customer getLoggedInCustomerDetails(String token) throws CustomerNotFoundException;
	
	public Customer updateCustomer(CustomerUpdateDTO customer, String token) throws CustomerNotFoundException;
	
	public Customer updateCustomerMobileNoOrEmailId(CustomerUpdateDTO customerUpdateDTO, String token) throws CustomerNotFoundException;

	public SessionDTO updateCustomerPassword(CustomerDTO customerDTO, String token) throws CustomerNotFoundException;
	
	public Customer updateAddress(Address address, String type, String token) throws CustomerException;
	
	public Customer deleteAddress(String type, String token) throws CustomerException, CustomerNotFoundException;
	
	public List<Order> getCustomerOrders(String token) throws CustomerException; 

}
