package com.hexaware.QuitQ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.QuitQ.DTO.CustomerDTO;
import com.hexaware.QuitQ.DTO.CustomerUpdateDTO;
import com.hexaware.QuitQ.DTO.SessionDTO;
import com.hexaware.QuitQ.entity.Address;
import com.hexaware.QuitQ.entity.Customer;
import com.hexaware.QuitQ.entity.Order;
import com.hexaware.QuitQ.service.CustomerService;


@CrossOrigin("http://localhost:3000")
@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	// Handler to get a list of all customers
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomersHandler(@RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.getAllCustomers(token), HttpStatus.ACCEPTED);
	}
	
	// Handler to Get a customer details of currently logged in user - sends data as per token
	
	@GetMapping("/customer/current")
	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(@RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.getLoggedInCustomerDetails(token), HttpStatus.ACCEPTED);
	}
	
	
	// Handler to Update a customer
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody CustomerUpdateDTO customerUpdate, @RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.updateCustomer(customerUpdate, token), HttpStatus.ACCEPTED);
	}
	
	// Handler to update a customer email-id or mobile no
	@PutMapping("/customer/update/credentials")
	public ResponseEntity<Customer> updateCustomerMobileEmailHandler(@RequestBody CustomerUpdateDTO customerUpdate, @RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.updateCustomerMobileNoOrEmailId(customerUpdate, token), HttpStatus.ACCEPTED);
	}
	
	// Handler to update customer password
	@PutMapping("/customer/update/password")
	public ResponseEntity<SessionDTO> updateCustomerPasswordHandler(@RequestBody CustomerDTO customerDto, @RequestHeader("token") String token){		
		return new ResponseEntity<>(customerService.updateCustomerPassword(customerDto, token), HttpStatus.ACCEPTED);
	}
	
	// Handler to Add or update new customer Address
	@PutMapping("/customer/update/address")
	public ResponseEntity<Customer> updateAddressHandler(@RequestBody Address address, @RequestParam("type") String type, @RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.updateAddress(address, type, token), HttpStatus.ACCEPTED);
	}
	
	// Handler to Remove a user address
	@DeleteMapping("/customer/delete/address")
	public ResponseEntity<Customer> deleteAddressHandler(@RequestParam("type") String type, @RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.deleteAddress(type, token), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customer/orders")
	public ResponseEntity<List<Order>> getCustomerOrdersHandler(@RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.getCustomerOrders(token), HttpStatus.ACCEPTED);
	}
}
