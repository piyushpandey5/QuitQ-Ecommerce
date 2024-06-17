package com.hexaware.QuitQ.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.QuitQ.entity.CategoryEnum;
import com.hexaware.QuitQ.entity.Product;
import com.hexaware.QuitQ.entity.ProductStatus;
import com.hexaware.QuitQ.entity.Seller;
import com.hexaware.QuitQ.exception.ProductNotFoundException;
import com.hexaware.QuitQ.repository.ProductDao;
import com.hexaware.QuitQ.repository.SellerDao;
import com.hexaware.QuitQ.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private SellerDao sellerDao;
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getAllProductsIncatalog() throws ProductNotFoundException{
		List<Product>list = productDao.findAll();
		if(list.size()>0) return list;
		else throw new ProductNotFoundException("No Products in Catalog");
	}
	
	@Override
	public Product getProductFromCatalogByIdHandler(int id) throws ProductNotFoundException{
		Optional<Product> opt = productDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else throw new ProductNotFoundException("Product not found with id - " + id);
	}
	
	@Override
	public String deleteProductFromCatalog(int id) throws ProductNotFoundException{
		Optional<Product>opt = productDao.findById(id);
		
		if(opt.isPresent()) {
			productDao.deleteById(id);
			return "delete from the database";
		}
		else throw new ProductNotFoundException("Product not found with id - " + id);
	}
	
	@Override
	public Product updateProductIncatalog(Product product,int id) {
		Optional<Product> opt = productDao.findById(id);

		if (opt.isPresent()) {
			Product curr = opt.get();
			curr.setProductName(product.getProductName());
			curr.setPrice(product.getPrice());
			curr.setDescription(product.getDescription());
			curr.setQuantity(product.getQuantity());
			curr.setCategory(product.getCategory());
			curr.setStatus(product.getStatus());
			return curr;
		} else
			throw new ProductNotFoundException("Product not found with given id");
	}
	
	@Override
	public List<Product> getAllProductsOfSeller(int id){
		List<Product>list = productDao.getProductsOfASeller(id);
		return list;
	}
	
	@Override
	public List<Product> getProductsOfCategory(CategoryEnum ce){
		List<Product>list = productDao.getProductsOfCategory(ce);
		if(list.size()>0)return list;
		else throw new com.hexaware.QuitQ.exception.CategoryNotFoundException("No Product found with category:"+ce);
	}
	
	@Override

	public List<Product> getProductsOfStatus(ProductStatus state){
		List<Product>list = productDao.getProductsWithStatus(state);
		if(list.size()>0) {
			return list;
		}
		else throw new ProductNotFoundException("No Product with the given status" + state);
	}
	
	@Override
	public Product addProductWithSeller(Product product, int sellerId) {
	    Optional<Seller> sellerOpt = sellerDao.findById(sellerId);
	    if (sellerOpt.isPresent()) {
	        Seller seller = sellerOpt.get();
	        product.setSeller(seller);
	        return productDao.save(product);
	    } else {
	    	throw new ProductNotFoundException("Product not found with given id");
	    }
	}
}
