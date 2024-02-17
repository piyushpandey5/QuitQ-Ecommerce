package com.hexaware.QuitQ.service;

import com.hexaware.QuitQ.entity.Cart;

public interface CartService {
	public Cart addProductToCart(Cart cart, String token);
}
