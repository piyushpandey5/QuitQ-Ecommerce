package com.hexaware.QuitQ.service;

import com.hexaware.QuitQ.DTO.CustomerDTO;
import com.hexaware.QuitQ.DTO.JWTAuthResponse;
import com.hexaware.QuitQ.DTO.LoginDto;
//import com.hexaware.QuitQ.DTO.LoginDto;
import com.hexaware.QuitQ.DTO.RegisterDto;
import com.hexaware.QuitQ.DTO.UserDTO;

public interface AuthService {
	JWTAuthResponse login(LoginDto dto);
	String register(UserDTO dto);
	void logout();
    boolean validateToken(String token);

}