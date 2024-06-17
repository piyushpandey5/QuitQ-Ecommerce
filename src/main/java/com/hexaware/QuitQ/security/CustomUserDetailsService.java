package com.hexaware.QuitQ.security;
import java.util.Collections;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.QuitQ.entity.User;
import com.hexaware.QuitQ.repository.UserDao;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	private UserDao userDao;
	// Constructor DI
	public CustomUserDetailsService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userDao.findByEmail(usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));
		Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()));
		return new org.springframework.security.core.userdetails.User(usernameOrEmail, user.getPassword(), authorities);
	}
}