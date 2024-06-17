package com.hexaware.QuitQ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.QuitQ.entity.CategoryEnum;
import com.hexaware.QuitQ.entity.Product;
import com.hexaware.QuitQ.entity.ProductStatus;
import com.hexaware.QuitQ.exception.ProductNotFoundException;
import com.hexaware.QuitQ.service.ProductService;

@RestController

@CrossOrigin("http://localhost:3000")
public class ProductController {
	

	@Autowired
	private ProductService pService;
	
	
	// return all the products in the database
	@GetMapping("/products")
	public ResponseEntity<List<Product>> addProductToCatalogHandler() {

		List<Product>list = pService.getAllProductsIncatalog();

		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);

	}
	
	//return the products with the given id
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductFromCatalogByIdHandler(@PathVariable("id")Integer id){
		Product prod = pService.getProductFromCatalogByIdHandler(id);
		return new ResponseEntity<Product>(prod,HttpStatus.FOUND);
	}
	
	//exception handler with response entity if product is not found with the given id
	@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
	
	// delete the product with the given id
	@DeleteMapping("product/{id}")
	public ResponseEntity<String>deleteProductFromCatalog(@PathVariable("id")Integer id){
		String res = pService.deleteProductFromCatalog(id);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	// updates the product in catalog by taking its id
	@PutMapping("/product/{id}")
	public ResponseEntity<Product>updateProductInCatalogHandler(@RequestBody Product prod,@PathVariable("id")Integer id){
		Product prod1 = pService.updateProductIncatalog(prod,id);
		return new ResponseEntity<Product>(prod1,HttpStatus.OK);
	}
	
	// returns the products of a seller by taking seller id
	@GetMapping("/products/seller/{id}")
	public ResponseEntity<List<Product>>getAllProductsOfSellerHandler(@PathVariable("id")int id){
		List<Product> list = pService.getAllProductsOfSeller(id);
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	// search products based on the category
	@GetMapping("/products/{catenum}")
	public ResponseEntity<List<Product>>getAllProductsInCategory(@PathVariable("catenum")String catenum){
		CategoryEnum ce = CategoryEnum.valueOf(catenum.toUpperCase());
		List<Product> list= pService.getProductsOfCategory(ce);
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/products/status/{status}")
	public ResponseEntity<List<Product>>getProductsWithStatusHandler(@PathVariable("status")String status){
		ProductStatus state = ProductStatus.valueOf(status.toUpperCase());
		List<Product> list= pService.getProductsOfStatus(state);
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	
	@PostMapping("/product/{sellerId}")
	public ResponseEntity<Product> addProductWithSellerHandler(@RequestBody Product product, @PathVariable("sellerId") int sellerId) {
	    Product addedProduct = pService.addProductWithSeller(product, sellerId);
	    return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
	}

	
}