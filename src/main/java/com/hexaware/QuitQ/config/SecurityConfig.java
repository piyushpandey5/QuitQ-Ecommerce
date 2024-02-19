//package com.hexaware.QuitQ.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.hexaware.QuitQ.security.JwtAuthenticationEntryPoint;
//import com.hexaware.QuitQ.security.JwtAuthenticationFilter;
//import com.hexaware.QuitQ.service.CustomerService;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig{
//	@Autowired
//	private CustomerService customerDetailService;
//	
//	@Autowired
//	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//	
//	@Autowired
//	private JwtAuthenticationFilter jwtAuthenticationFilter;
//	
//	@Override
//	protected void configure(HttpSecurity http) throws exception{
//		http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
//		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
//		http.addFilterBefore(this.jwtAuthenticationEntryPoint,UsernamePasswordAuthenticationFilter.class);
//    }
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception{
//		return builder.getAuthenticationManager();
//	}
//	
//}
