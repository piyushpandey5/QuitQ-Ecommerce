package com.hexaware.QuitQ.service;

import java.util.List;

import com.hexaware.QuitQ.DTO.CartDTO;
import com.hexaware.QuitQ.entity.Cart;
import com.hexaware.QuitQ.entity.CartItem;

public interface CartService {
	public Cart addProductToCart(CartDTO cartdto, String token);

	public List<CartItem>  getCartProduct(String token);

	public Cart removeProductFromCart(CartDTO cartdto, String token);

	public Cart clearCart(String token);
}
