package com.hexaware.QuitQ.service.serviceimpl;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.QuitQ.DTO.CustomerDTO;
import com.hexaware.QuitQ.DTO.SellerDTO;
import com.hexaware.QuitQ.DTO.UserDTO;
import com.hexaware.QuitQ.entity.Customer;
import com.hexaware.QuitQ.entity.Role;
import com.hexaware.QuitQ.entity.Seller;
import com.hexaware.QuitQ.entity.User;
import com.hexaware.QuitQ.repository.CustomerDao;
import com.hexaware.QuitQ.repository.SellerDao;
import com.hexaware.QuitQ.repository.UserDao;
import com.hexaware.QuitQ.service.UserService;

import ch.qos.logback.classic.Level;

@Service
public class UserServiceImpl implements UserService {
	
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	private ModelMapper modelMapper;
	
    @Autowired
	private UserDao userDao;
    
    @Autowired
    private CustomerDao employerDao;
    
    @Autowired
    private SellerDao sellerDao;
	public UserServiceImpl(UserDao userDao)
	{
		super();
		this.userDao=userDao;
	}
	
	@Override
	public User createUser(User user) {
		User savedUser=userDao.save(user);
		return savedUser;
	}

	
	@Override
	public UserDTO createUser(UserDTO user) {
		User userEntity=modelMapper.map(user, User.class);
		User savedUser=userDao.save(userEntity);
		user=modelMapper.map(savedUser,UserDTO.class );
		return user;
	}

	@Override
	public List<UserDTO> createUsers(List<UserDTO> user) {
		List<User> users=user.stream().map(userDTO->modelMapper.map(userDTO,User.class)).collect(Collectors.toList());
		List<User> savedUsers=userDao.saveAll(users);
		user=savedUsers.stream().map(User->modelMapper.map(savedUsers, UserDTO.class)).collect(Collectors.toList());
		return user;
	}

	@Override
	public UserDTO updateName(Long id,String name) {
		User user=userDao.findById(id).orElse(null);
		UserDTO userDTO=null;
		if(user!=null)
		{
			user.setName(name);
			userDao.save(user);
			userDTO=modelMapper.map(user,UserDTO.class );
		}
		return userDTO;
	}

	@Override
	public UserDTO updateEmail(Long id,String email) {
		User user=userDao.findById(id).orElse(null);
		UserDTO userDTO=null;
		if(user!=null)
		{
			user.setEmail(email);
			userDao.save(user);
			userDTO=modelMapper.map(user,UserDTO.class );
		}
		return userDTO;
	}

	@Override
	public User changePassword(Long id,String password ) {
		User user=userDao.findById(id).orElse(null);
		if(user!=null)
		{
			user.setPassword(password);
			userDao.save(user);
		}
		return user;
	}

	@Override
	public List<UserDTO> findByName(String name) {
		List<User> user=userDao.findByName(name).orElse(null);
		List<UserDTO> users=user.stream().map(User->modelMapper.map(User, UserDTO.class)).collect(Collectors.toList());
		return users;
	}

	@Override
	public List<UserDTO> findAll() {
	    List<User> users = userDao.findAll();
	    List<UserDTO> userDTOs = users.stream()
	                                  .map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	    System.out.println(""+ userDTOs.toString());
	    return userDTOs;
	}

	@Override
	public UserDTO findByUserId(Long id) {
		User user=userDao.findByUserId(id).orElse(null);
		UserDTO userDTO=null;
		if(user!=null)
		{
		userDTO=modelMapper.map(user, UserDTO.class);
		}
		return userDTO;
	}

	@Override
	public UserDTO findByEmail(String email) {
		User user=userDao.findByEmail(email).orElse(null);
		UserDTO userDTO=modelMapper.map(user, UserDTO.class);
		return userDTO;
		}

	@Override
	public List<UserDTO> findByRole(Role role) 
	{
		List<User> user=new ArrayList<>();
		user.addAll(userDao.findByRole(role));
		List<UserDTO> users=user.stream().map(User->modelMapper.map(User, UserDTO.class)).collect(Collectors.toList());
		return users;	
	}

	@Override
	public List<UserDTO> findByNameContaining(String name) 
	{
		List<User> user=new ArrayList<>();
		user.addAll(userDao.findByNameContaining(name));
		List<UserDTO> users=user.stream().map(User->modelMapper.map(User, UserDTO.class)).collect(Collectors.toList());
		return users;		
	}

	@Override
	public List<UserDTO> findByNameIn(List<String> names) {
		List<User> user=new ArrayList<>();
		user.addAll(userDao.findByNameIn(names));
		List<UserDTO> users=user.stream().map(User->modelMapper.map(User, UserDTO.class)).collect(Collectors.toList());
		return users;
	}

	@Override
	public User deleteById(Long id) {
		User user=userDao.findById(id).orElse(null);
		if(user!=null)
		{
		userDao.deleteById(id);
		}
		return user;
		
	}

	@Override
	public List<UserDTO> deleteAll() {
		List<User> users=new ArrayList<>();
		users.addAll(userDao.findAll());
		if(users!=null)
		{
			userDao.deleteAll();
		}
		List<UserDTO> userDTOs=users.stream().map(User->modelMapper.map(User, UserDTO.class)).collect(Collectors.toList());
		return userDTOs;
	}
	@Override
	public long count() {
		Long count=userDao.count();
		return count;
	}

	@Override
	public List<User> deleteAll(List<User> users) {
		List<User> user=new ArrayList<>();
		user.addAll(users);
		if(user!=null)
		{
			userDao.deleteAll(users);
		}
		return user;
		
	}

	@Override
	public UserDTO updateUser(Long userId, UserDTO userDTO) {
		User user=userDao.findById(userId).orElse(null);
		UserDTO user1=null;
		if(user!=null)
		{
			user.setEmail(userDTO.getEmail());
			user.setName(userDTO.getName());
			user.setPassword(userDTO.getPassword());
			user.setRole(Role.valueOf(userDTO.getRole().toUpperCase()));
			userDao.save(user);
			user1=modelMapper.map(user,UserDTO.class);
		}
		
		return user1;
	}
	@Override
	public UserDTO addEmployer(Long userId, CustomerDTO customerDTO) {
		User user=userDao.findById(userId).orElse(null);
		UserDTO user1=null;
		if(user!=null)
		{
			Customer customerEntity=modelMapper.map(customerDTO, Customer.class);
			Customer customer1=employerDao.save(customerEntity);
			customerDTO=modelMapper.map(customer1,CustomerDTO.class);
			user.setCustomer(customer1);
			userDao.save(user);
			user1=modelMapper.map(user,UserDTO.class);
		}
		
		return user1;
	}
	@Override
	public UserDTO addJobSeeker(Long userId, SellerDTO sellerDto) {
		User user=userDao.findById(userId).orElse(null);
		UserDTO user1=null;
		if(user!=null)
		{
		
			Seller sellerEntity=  modelMapper.map(sellerDto, Seller.class);
			Seller savedSeller= sellerDao.save(sellerEntity);
			sellerDto=modelMapper.map(savedSeller,SellerDTO.class );
			user.setSeller(savedSeller);
			userDao.save(user);
			user1=modelMapper.map(user,UserDTO.class);
		}
		
		return user1;
	}

}