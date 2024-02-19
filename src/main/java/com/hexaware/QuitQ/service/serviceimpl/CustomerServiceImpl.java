package com.hexaware.QuitQ.service.serviceimpl;
import com.hexaware.QuitQ.entity.Order;
import com.hexaware.QuitQ.entity.UserSession;
import com.hexaware.QuitQ.exception.CustomerException;
import com.hexaware.QuitQ.exception.CustomerNotFoundException;
import com.hexaware.QuitQ.exception.LoginException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.QuitQ.DTO.CustomerDTO;
import com.hexaware.QuitQ.DTO.CustomerUpdateDTO;
import com.hexaware.QuitQ.DTO.SessionDTO;
import com.hexaware.QuitQ.entity.Address;
import com.hexaware.QuitQ.entity.Cart;
import com.hexaware.QuitQ.entity.Customer;
import com.hexaware.QuitQ.repository.CustomerDao;
import com.hexaware.QuitQ.repository.SessionDao;
import com.hexaware.QuitQ.service.CustomerService;
import com.hexaware.QuitQ.service.LoginLogoutService;


@Service
public class CustomerServiceImpl implements  CustomerService{


	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private LoginLogoutService loginService;
	
	@Autowired
	private SessionDao sessionDao;
	
	// Method to add a new customer
		
	@Override
	public Customer addCustomer(Customer customer) {
				
		customer.setCreatedOn(LocalDateTime.now());
		
		Cart c = new Cart();
		
		System.out.println(c);
		
//		System.out.println(c.getProducts().size());
			
		customer.setCustomerCart(c);
		
		customer.setOrders(new ArrayList<Order>());

		Optional<Customer> existing = customerDao.findByMobileNo(customer.getMobileNo());
		
		if(existing.isPresent())
			throw new CustomerException("Customer already exists. Please try to login with your mobile no");
		
		customerDao.save(customer);
		
		return customer;
	}

	
	//method to get all the customers
	@Override
	public List<Customer> getAllCustomers(String token) throws CustomerNotFoundException {
		
		// update to seller
		
		if(token.contains("seller") == false) {
			throw new LoginException("Invalid session token.");
		}
		
		loginService.checkTokenStatus(token);
		
		List<Customer> customers = customerDao.findAll();
		
		if(customers.size() == 0)
			throw new CustomerNotFoundException("No record exists");
		
		return customers;
	}
	
	//method to get logged in customer
	
	
	@Override
	public Customer getLoggedInCustomerDetails(String token){
		
		if(token.contains("customer") == false) {
			throw new LoginException("Invalid session token for customer");
		}
		
		loginService.checkTokenStatus(token);
		
		UserSession user = sessionDao.findByToken(token).get();
		
		Optional<Customer> opt = customerDao.findById((int) user.getUserId());
		
		if(opt.isEmpty())
			throw new CustomerNotFoundException("Customer does not exist");
		
		Customer existingCustomer = opt.get();
		
		return existingCustomer;
	}
	
	// Method to update entire customer details - either mobile number or email id should be correct
	
	@Override
	public Customer updateCustomer(CustomerUpdateDTO customer, String token) throws CustomerNotFoundException {
		
		
		if(token.contains("customer") == false) {
			throw new LoginException("Invalid session token for customer");
		}
		
		loginService.checkTokenStatus(token);
		
		Optional<Customer> opt = customerDao.findByMobileNo(customer.getMobileNo());
		
		Optional<Customer> res = customerDao.findByEmailId(customer.getEmailId());
		

		if(opt.isEmpty() && res.isEmpty())
			throw new CustomerNotFoundException("Customer does not exist with given mobile no or email-id");

		Customer existingCustomer = null;
		
		if(opt.isPresent())
			existingCustomer = opt.get();
		else
			existingCustomer = res.get();
		
		UserSession user = sessionDao.findByToken(token).get();
		
		if(existingCustomer.getCustomerId() == user.getUserId()) {
		
			if(customer.getFirstName() != null) {
				existingCustomer.setFirstName(customer.getFirstName());
			}
			
			if(customer.getLastName() != null) {
				existingCustomer.setLastName(customer.getLastName());
			}
			
			if(customer.getEmailId() != null) {
				existingCustomer.setEmailId(customer.getEmailId());
			}
			
			if(customer.getMobileNo() != null) {
				existingCustomer.setMobileNo(customer.getMobileNo());
			}
			
			if(customer.getPassword() != null) {
				existingCustomer.setPassword(customer.getPassword());
			}
			
			if(customer.getAddress() != null) {			
				for(Map.Entry<String, Address> values : customer.getAddress().entrySet()) {
					existingCustomer.getAddress().put(values.getKey(), values.getValue());
				}
			}
			
			customerDao.save(existingCustomer);
			return existingCustomer;
		
		}
		else {
			throw new CustomerException("Error in updating. Verification failed.");
		}
		
		
	}
	
	@Override
	public Customer updateCustomerMobileNoOrEmailId(CustomerUpdateDTO customerUpdateDTO, String token) throws CustomerNotFoundException {
		
		if(token.contains("customer") == false) {
			throw new LoginException("Invalid session token for customer");
		}
		
		loginService.checkTokenStatus(token);
		
		UserSession user = sessionDao.findByToken(token).get();
		
		Optional<Customer> opt = customerDao.findById((int) user.getUserId());
		
		if(opt.isEmpty())
			throw new CustomerNotFoundException("Customer does not exist");
		
		Customer existingCustomer = opt.get();
		
		if(customerUpdateDTO.getEmailId() != null) {
			existingCustomer.setEmailId(customerUpdateDTO.getEmailId());
		}
		
		
		existingCustomer.setMobileNo(customerUpdateDTO.getMobileNo());
			
		customerDao.save(existingCustomer);
			
		return existingCustomer;
		
	}
	
	// Method to update password - based on current token
	
		@Override
	public SessionDTO updateCustomerPassword(CustomerDTO customerDTO, String token) {
		
		
		if(token.contains("customer") == false) {
			throw new LoginException("Invalid session token for customer");
		}
			
		
		loginService.checkTokenStatus(token);
		
		UserSession user = sessionDao.findByToken(token).get();
		
		Optional<Customer> opt = customerDao.findById((int) user.getUserId());
		
		if(opt.isEmpty())
			throw new CustomerNotFoundException("Customer does not exist");
		
		Customer existingCustomer = opt.get();
		
		
		if(customerDTO.getMobileId().equals(existingCustomer.getMobileNo()) == false) {
			throw new CustomerException("Verification error. Mobile number does not match");
		}
		
		existingCustomer.setPassword(customerDTO.getPassword());
		
		customerDao.save(existingCustomer);
		
		SessionDTO session = new SessionDTO();
		
		session.setToken(token);
		
		loginService.logoutCustomer(session);
		
		session.setMessage("Updated password and logged out. Login again with new password");
		
		return session;

	}
		
	
	// Method to add/update Address
		
	@Override
	public Customer updateAddress(Address address, String type, String token) throws CustomerException {
		if(token.contains("customer") == false) {
			throw new LoginException("Invalid session token for customer");
		}
			
		loginService.checkTokenStatus(token);
		
		UserSession user = sessionDao.findByToken(token).get();
		
		Optional<Customer> opt = customerDao.findById((int) user.getUserId());
		

		if(opt.isEmpty())
			throw new CustomerNotFoundException("Customer does not exist");
			
			Customer existingCustomer = opt.get();
			
			existingCustomer.getAddress().put(type, address);
			
			return customerDao.save(existingCustomer);
			
		}
	@Override
	public Customer deleteAddress(String type, String token) throws CustomerException, CustomerNotFoundException {
		
		if(token.contains("customer") == false) {
			throw new LoginException("Invalid session token for customer");
		}
		
		loginService.checkTokenStatus(token);
		
		UserSession user = sessionDao.findByToken(token).get();
		
		Optional<Customer> opt = customerDao.findById((int) user.getUserId());
		
		if(opt.isEmpty())
			throw new CustomerNotFoundException("Customer does not exist");
		
		Customer existingCustomer = opt.get();
		
		if(existingCustomer.getAddress().containsKey(type) == false)
			throw new CustomerException("Address type does not exist");
		
		existingCustomer.getAddress().remove(type);
		
		return customerDao.save(existingCustomer);
	}
	
	@Override
	public List<Order> getCustomerOrders(String token) throws CustomerException {
		
		if(token.contains("customer") == false) {
			throw new LoginException("Invalid session token for customer");
		}
		
		loginService.checkTokenStatus(token);
		
		UserSession user = sessionDao.findByToken(token).get();
		
		Optional<Customer> opt = customerDao.findById((int) user.getUserId());
		
		if(opt.isEmpty())
			throw new CustomerNotFoundException("Customer does not exist");
		
		Customer existingCustomer = opt.get();
		
		List<Order> myOrders = existingCustomer.getOrders();
		
		if(myOrders.size() == 0)
			throw new CustomerException("No orders found");
		
		return myOrders;
	}
}
