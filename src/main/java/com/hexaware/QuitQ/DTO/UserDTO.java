package com.hexaware.QuitQ.DTO;

import com.hexaware.QuitQ.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	private Long userId;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Email(message = "Email should be valid")
    private String email;
	private String password;

    @NotNull(message = "Role should not be null")
    private String role; // String field for role selection

    private CustomerDTO customer;
    private SellerDTO seller;

    public UserDTO() {
        super();
    }

    public UserDTO(Long userId,
            @NotEmpty(message = "Name should not be empty") @Size(min = 2, message = "Name should have at least 2 characters") String name,
            @Email(message = "Email should be valid") String email, String password,
            @NotNull(message = "Role should not be null") String role, CustomerDTO customer, SellerDTO seller) {
        super();
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.customer = customer;
        this.seller = seller;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public SellerDTO getSeller() {
        return seller;
    }

    public void setSeller(SellerDTO seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "UserDTO [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
                + ", role=" + role + ", customer=" + customer + ", seller=" + seller + "]";
    }
}
