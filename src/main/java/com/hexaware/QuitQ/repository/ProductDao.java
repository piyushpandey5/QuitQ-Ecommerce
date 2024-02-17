package com.hexaware.QuitQ.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.QuitQ.entity.CategoryEnum;
import com.hexaware.QuitQ.entity.Product;
import com.hexaware.QuitQ.entity.ProductStatus;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{
	@Query("SELECT p FROM Product p WHERE p.seller.sellerId = :id")
	public List<Product> getProductsOfASeller(@Param("id") Integer id);

	@Query("SELECT p FROM Product p WHERE p.category = :ce")
	public List<Product> getProductsOfCategory(@Param("ce")CategoryEnum ce);
	

	@Query("SELECT p FROM Product p WHERE p.status = :state")
	public List<Product> getProductsWithStatus(@Param("state")ProductStatus state);
}
