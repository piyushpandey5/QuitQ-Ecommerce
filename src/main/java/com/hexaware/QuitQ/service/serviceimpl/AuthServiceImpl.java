package com.hexaware.QuitQ.service.serviceimpl;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.QuitQ.DTO.JWTAuthResponse;
import com.hexaware.QuitQ.DTO.LoginDto;
import com.hexaware.QuitQ.DTO.UserDTO;
import com.hexaware.QuitQ.entity.Role;
import com.hexaware.QuitQ.entity.User;
import com.hexaware.QuitQ.exception.BadRequestException;
import com.hexaware.QuitQ.repository.UserDao;
import com.hexaware.QuitQ.security.JwtTokenProvider;
import com.hexaware.QuitQ.service.AuthService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
	private AuthenticationManager authenticationManager;
	private UserDao userRepo;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	public AuthServiceImpl(AuthenticationManager authenticationManager, 
			UserDao userRepo,PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	@Override
	public JWTAuthResponse login(LoginDto dto) {
		
		System.out.println(("object received "+dto));
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
		System.out.println(authentication);
		System.out.println(("object received here"));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenProvider.generateToken(authentication);
		System.out.println("Token generated : "+token);
		User user = userRepo.findByEmail(dto.getEmail()).get();
		System.out.println("user object found in repo "+user);
		UserDTO userDto = modelMapper.map(user, UserDTO.class);

		return new JWTAuthResponse(token,userDto);
	}

	
	@Override
	public String register(UserDTO dto) {
	    if (userRepo.findByEmail(dto.getEmail()).isPresent()) {
	        throw new BadRequestException(HttpStatus.BAD_REQUEST, "Email already exists");
	    }

	    // Encode the password using BCrypt
	    String encodedPassword = passwordEncoder.encode(dto.getPassword());

	    // Map UserDTO to User entity
	    User user = modelMapper.map(dto, User.class);

	    // Set the encoded password and save the user
	    user.setPassword(encodedPassword);
	    userRepo.save(user);

	    return "Registration Successful!";
	}
	@Override
	public void logout() {
	    SecurityContextHolder.clearContext();
	}
	@Override
	public boolean validateToken(String token) {
	    return jwtTokenProvider.validateToken(token);
	}


}