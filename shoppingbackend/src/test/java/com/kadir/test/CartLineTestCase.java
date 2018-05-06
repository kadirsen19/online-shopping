package com.kadir.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kadir.dao.CartLineDAO;
import com.kadir.dao.ProductDAO;
import com.kadir.dao.UserDAO;
import com.kadir.model.Cart;
import com.kadir.model.CartLine;
import com.kadir.model.Product;
import com.kadir.model.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.kadir");
		context.refresh();
		cartLineDAO=(CartLineDAO)context.getBean("cartLineDAO");
		productDAO=(ProductDAO)context.getBean("productDAO");
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void testAddNewCartLine() {
		
		//1. get the user
		User user =userDAO.getUserByEmail("ahmetaltun@gmail.com");
		//2.fetch the cart
		Cart cart =user.getCart();
		//3.get the product
		Product product= productDAO.getProduct(7);
		//4.create a new cartLine
		CartLine cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount()* product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine ",true,cartLineDAO.addCartLine(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal()+ cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		
		assertEquals("Failed to update the cart ",true,cartLineDAO.updateCart(cart));
	}
	
}
