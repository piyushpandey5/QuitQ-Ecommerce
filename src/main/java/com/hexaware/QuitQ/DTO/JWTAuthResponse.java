package com.hexaware.QuitQ.DTO;

public class JWTAuthResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	private UserDTO userDTO;//appending user details and JWT Token in response
	public JWTAuthResponse() {	}
	public JWTAuthResponse(String accessToken, UserDTO userDTO) {
		super();
		this.accessToken = accessToken;
		this.userDTO = userDTO;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public UserDTO getUserDto() {
		return userDTO;
	}
	public void setUserDto(UserDTO userDTO) {
		this.userDTO = userDTO;
	}}