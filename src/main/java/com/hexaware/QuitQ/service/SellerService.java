package com.hexaware.QuitQ.service;

import java.util.List;

import com.hexaware.QuitQ.DTO.SellerDTO;
import com.hexaware.QuitQ.DTO.SessionDTO;
import com.hexaware.QuitQ.entity.Seller;
import com.hexaware.QuitQ.exception.SellerException;

public interface SellerService {

	public Seller addSeller(Seller seller);
	public List<Seller> getAllSellers() throws SellerException;
	public Seller getSellerById(Integer sellerId)throws SellerException;
	
	public Seller getSellerByMobile(String mobile, String token) throws SellerException;
	
	public Seller getCurrentlyLoggedInSeller(String token) throws SellerException;
	
	public SessionDTO updateSellerPassword(SellerDTO sellerDTO, String token) throws SellerException;
	
	public Seller updateSeller(Seller seller, String token)throws SellerException;
	
	public Seller updateSellerMobile(SellerDTO sellerdto, String token)throws SellerException;
	
	public Seller deleteSellerById(Integer sellerId, String token)throws SellerException;
}
