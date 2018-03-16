package com.kadir.dao;

import java.util.List;

import com.kadir.model.Product;

public interface ProductDAO {

	public Product getProduct(int productId);
	public List<Product> allProductList();
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	
	//relative of active product
	public List<Product> activeProductList();
	public List<Product> activeProductsByCatagoryList(int catagoryId);
	public List<Product> latestActiveProductsList(int count);
	
	
}
