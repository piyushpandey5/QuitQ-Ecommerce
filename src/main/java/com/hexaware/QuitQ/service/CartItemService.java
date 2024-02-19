package com.hexaware.QuitQ.service;

import com.hexaware.QuitQ.DTO.CartDTO;
import com.hexaware.QuitQ.entity.CartItem;

public interface CartItemService {
	public CartItem createItemforCart(CartDTO cartdto);
}
