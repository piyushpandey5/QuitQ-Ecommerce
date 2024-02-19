package com.hexaware.QuitQ.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.QuitQ.DTO.CartDTO;
import com.hexaware.QuitQ.entity.CartItem;
import com.hexaware.QuitQ.entity.Product;
import com.hexaware.QuitQ.entity.ProductStatus;
import com.hexaware.QuitQ.exception.ProductNotFoundException;
import com.hexaware.QuitQ.repository.ProductDao;
import com.hexaware.QuitQ.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	ProductDao productDao;

	@Override
	public CartItem createItemforCart(CartDTO cartdto) {
		
		Product existingProduct = productDao.findById(cartdto.getProductId()).orElseThrow( () -> new ProductNotFoundException("Product Not found"));
		
		if(existingProduct.getStatus().equals(ProductStatus.OUTOFSTOCK) || existingProduct.getQuantity() == 0) {
			throw new ProductNotFoundException("Product OUT OF STOCK");
		}
		
		CartItem newItem = new CartItem();
		
		newItem.setCartItemQuantity(1);
		
		newItem.setCartProduct(existingProduct);
		
		return newItem;
	}
}
	
