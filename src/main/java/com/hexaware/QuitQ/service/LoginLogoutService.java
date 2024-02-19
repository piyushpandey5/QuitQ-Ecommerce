package com.hexaware.QuitQ.service;

import com.hexaware.QuitQ.DTO.CustomerDTO;
import com.hexaware.QuitQ.DTO.SellerDTO;
import com.hexaware.QuitQ.DTO.SessionDTO;
import com.hexaware.QuitQ.entity.UserSession;

public interface LoginLogoutService {
	public UserSession loginCustomer(CustomerDTO customer);

	SessionDTO logoutCustomer(SessionDTO sessionToken);

	void checkTokenStatus(String token);

	void deleteExpiredTokens();

	public UserSession loginSeller(SellerDTO seller);
	
	public SessionDTO logoutSeller(SessionDTO session);
}
