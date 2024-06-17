package com.hexaware.QuitQ.service;

import java.util.List;

import com.hexaware.QuitQ.DTO.CustomerDTO;
import com.hexaware.QuitQ.DTO.SellerDTO;
import com.hexaware.QuitQ.DTO.UserDTO;
import com.hexaware.QuitQ.entity.Role;
import com.hexaware.QuitQ.entity.User;

public interface UserService {
	public User createUser(User user);
	public UserDTO createUser(UserDTO user);
	public List<UserDTO> findByName(String name);
	public List<UserDTO> findAll();

	public UserDTO findByUserId(Long id);
	public UserDTO findByEmail(String email);
	public List<UserDTO> findByRole(Role role);
	public List<UserDTO> findByNameContaining(String name);
	public List<UserDTO> findByNameIn(List<String> names);
	public User deleteById(Long id);
	public List<UserDTO> deleteAll();
	public long count();
	public List<User> deleteAll(List<User> user);
	public UserDTO updateName(Long id,String name);
	public UserDTO updateEmail(Long id,String Email);
	public User changePassword(Long id,String password);
	public List<UserDTO> createUsers(List<UserDTO> user);
	public UserDTO updateUser(Long userId, UserDTO userDTO);
	UserDTO addEmployer(Long userId, CustomerDTO employerDto);
	UserDTO addJobSeeker(Long userId, SellerDTO jobSeekerDto);
}