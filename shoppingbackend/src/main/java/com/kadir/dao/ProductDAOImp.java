package com.kadir.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kadir.model.Product;

public class ProductDAOImp implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product getProduct(int productId) {
		
		Session session = sessionFactory.getCurrentSession();
		Product product =session.get(Product.class, Integer.valueOf(productId));
		return product;
	}

	@Override
	public List<Product> allProductList() {
		
		return null;
	}

	@Override
	public boolean addProduct(Product product) {

		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) {
		
		return false;
	}

	@Override
	public List<Product> activeProductList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> activeProductsByCatagoryList(int catagoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> latestActiveProductsList(int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
