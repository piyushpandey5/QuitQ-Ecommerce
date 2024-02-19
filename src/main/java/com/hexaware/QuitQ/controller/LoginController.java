package com.hexaware.QuitQ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.QuitQ.DTO.CustomerDTO;
import com.hexaware.QuitQ.DTO.SellerDTO;
import com.hexaware.QuitQ.DTO.SessionDTO;
import com.hexaware.QuitQ.entity.Customer;
import com.hexaware.QuitQ.entity.Seller;
import com.hexaware.QuitQ.entity.UserSession;
import com.hexaware.QuitQ.service.CustomerService;
import com.hexaware.QuitQ.service.LoginLogoutService;
import com.hexaware.QuitQ.service.SellerService;

@RestController
public class LoginController {
	@Autowired
	private CustomerService customerService;
//	
	@Autowired
	private LoginLogoutService loginService;
	
	@Autowired
	private SellerService sellerService;
	
	
	
	// Handler to register a new customer
	
	@PostMapping(value = "/register/customer", consumes = "application/json")
	public ResponseEntity<Customer> registerAccountHandler(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/login/customer", consumes = "application/json")
	public ResponseEntity<UserSession> loginCustomerHandler(@RequestBody CustomerDTO customerdto){
		return new ResponseEntity<>(loginService.loginCustomer(customerdto), HttpStatus.ACCEPTED);
	}
	
	// Handler to logout a user
	
	@PostMapping(value = "/logout/customer", consumes = "application/json")
	public ResponseEntity<SessionDTO> logoutCustomerHandler(@RequestBody SessionDTO sessionToken){
		return new ResponseEntity<>(loginService.logoutCustomer(sessionToken), HttpStatus.ACCEPTED);
	}
	
	
	/*********** SELLER REGISTER LOGIN LOGOUT HANDLER ************/
	
	@PostMapping(value = "/register/seller", consumes = "application/json")
	public ResponseEntity<Seller> registerSellerAccountHandler(@RequestBody Seller seller) {
		return new ResponseEntity<>(sellerService.addSeller(seller), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/login/seller", consumes = "application/json")
	public ResponseEntity<UserSession> loginSellerHandler(@RequestBody SellerDTO seller){
		return new ResponseEntity<>(loginService.loginSeller(seller), HttpStatus.ACCEPTED);
	}
	// Handler to logout a user
	
	@PostMapping(value = "/logout/seller", consumes = "application/json")
	public ResponseEntity<SessionDTO> logoutSellerHandler(@RequestBody SessionDTO sessionToken){
		return new ResponseEntity<>(loginService.logoutSeller(sessionToken), HttpStatus.ACCEPTED);
	}
	
}
