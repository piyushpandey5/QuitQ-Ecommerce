package com.hexaware.QuitQ.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="seller")
public class Seller {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long sellerId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	
	@Column(nullable = false)
	private String mobileNo;
	
	@OneToMany
	private List<Product> products;

	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seller(long sellerId, String firstName, String lastName, String password, String email, String mobileNo,
			List<Product> products) {
		super();
		this.sellerId = sellerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.mobileNo = mobileNo;
		this.products = products;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", emailId=" + email + ", mobileNo=" + mobileNo + ", products=" + products + "]";
	}
	

}
