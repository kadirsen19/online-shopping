package com.kadir.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kadir.config.HibernateConfig;
import com.kadir.dao.ProductDAO;
import com.kadir.model.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	@BeforeClass
	public static void init() {
		
		context= new AnnotationConfigApplicationContext(HibernateConfig.class);
		context.scan("com.kadir");
		productDAO = context.getBean("productDAO",ProductDAO.class);
	}
	
	@Test
	public void testGetProduct() {
		
		product = productDAO.getProduct(2);
		System.out.println(product);
		
		assertEquals("Success getting product", "Samsung s7", product.getName());
		
	}
	/*@Test
	public void testGetListProduct() {
		
		assertEquals("Getting success list product", 5, productDAO.allProductList().size());
	}
	@Test
	public void testActiveGetListProduct() {
		
		assertEquals("Getting success list product", 5, productDAO.activeProductList().size());
	}
	@Test
	public void testActiveGetListProductByCategoryId() {
		
		assertEquals("Getting success list product", 3, productDAO.activeProductsByCatagoryList(3).size());
	}*/
	@Test
	public void testActiveGetLatestListProduct() {
		
		assertEquals("Getting success list product", 3, productDAO.latestActiveProductsList(3).size());
		
	}
}
