package com.hexaware.QuitQ.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cartId;
	private double cartTotal;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<CartItem> cartItems = new ArrayList<>();
		
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Customer customer;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(long cartId, double cartTotal, List<CartItem> cartItems, Customer customer) {
		super();
		this.cartId = cartId;
		this.cartTotal = cartTotal;
		this.cartItems = cartItems;
		this.customer = customer;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartTotal=" + cartTotal + ", cartItems=" + cartItems + ", customer="
				+ customer + "]";
	}


}
