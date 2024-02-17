package com.hexaware.QuitQ.service;


import java.util.List;

import com.hexaware.QuitQ.entity.CategoryEnum;
import com.hexaware.QuitQ.entity.Product;
import com.hexaware.QuitQ.entity.ProductStatus;

public interface ProductService {
	public List<Product> getAllProductsIncatalog();
	public Product getProductFromCatalogByIdHandler(int id);
	public String deleteProductFromCatalog(int id);
	public Product updateProductIncatalog(Product product,int id);
	public List<Product> getAllProductsOfSeller(int id);
	public List<Product> getProductsOfCategory(CategoryEnum ce);
	public List<Product> getProductsOfStatus(ProductStatus state);

}
