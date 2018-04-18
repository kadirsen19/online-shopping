package com.kadir.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kadir.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImp implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product getProduct(int productId) {

		try {
			return sessionFactory.getCurrentSession().get(Product.class, productId);

		} catch (Exception e) {
			System.out.println("While getting product error" + e);
			return null;
		}

	}

	@Override
	public List<Product> allProductList() {
		String query = " from Product ";

		try {
			TypedQuery<Product> typedQuery = sessionFactory.getCurrentSession().createQuery(query, Product.class);

			return typedQuery.getResultList();

		} catch (Exception e) {
			System.out.println("While Getting productList error" + e);
			return null;
		}
	}

	@Override
	public boolean addProduct(Product product) {

		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;

		} catch (Exception e) {
			System.out.println("While Adding product error" + e);
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {

		try {

			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {
			System.out.println("Updating product error" + e);
			return false;
		}

	}

	@Override
	public boolean deleteProduct(Product product) {

		product.setActive(false);

		try {
			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {
			System.out.println("While deleting product error" + e);
			return false;
		}
	}

	@Override
	public List<Product> activeProductList() {

		String query = "From Product WHERE active =:active";

		TypedQuery<Product> typedQuery = sessionFactory.getCurrentSession()
														.createQuery(query, Product.class);
		typedQuery.setParameter("active", true);

		return typedQuery.getResultList();
	}

	@Override
	public List<Product> activeProductsByCatagoryList(int catagoryId) {

		String query = "From Product WHERE active =:active AND categoryId =:categoryID";
		TypedQuery<Product> typedQuery = sessionFactory.getCurrentSession()
														.createQuery(query, Product.class);
		typedQuery.setParameter("active", true);
		typedQuery.setParameter("categoryID", catagoryId);

		for(Product product : typedQuery.getResultList())
		{
			System.out.println(product);
		}
		
		return typedQuery.getResultList();
	}

	@Override
	public List<Product> latestActiveProductsList(int count) {
		String query = "From Product WHERE active =:active ORDER BY  id ";
		TypedQuery<Product> typedQuery = sessionFactory.getCurrentSession()
										.createQuery(query, Product.class);
		typedQuery.setParameter("active", true);
		typedQuery.setFirstResult(0);
		typedQuery.setMaxResults(count);
		
		for(Product product : typedQuery.getResultList())
		{
			System.out.println(product);
		}
		
		return typedQuery.getResultList();
	}
	
}
