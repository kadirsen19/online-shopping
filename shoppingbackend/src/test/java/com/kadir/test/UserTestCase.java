package com.kadir.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;
import com.kadir.dao.UserDAO;
import com.kadir.model.Address;
import com.kadir.model.Cart;
import com.kadir.model.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context= new AnnotationConfigApplicationContext();
		context.scan("com.kadir");
		context.refresh();
		
		userDAO= (UserDAO) context.getBean("userDAO");
	}
	/*@Test
	public void addTest() {
		
		user= new User();
		user.setLastName("sen");
		user.setFirstName("kadir");
		user.setEmail("kadirsen19@gmail.com");
		user.setContactNumber("5364642565");
		user.setRole("USER");
		user.setPassword("kadirsen19");
		//add the user
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));	
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near the school");
		address.setCity("CORUM");
		address.setState("Sakarya");
		address.setCountry("Turkey");
		address.setPostalCode("19100");
		address.setBilling(true);
		
		//link the user with the address using user id
		address.setUserId(user.getId());
		
		//add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));	
		
		if(user.getRole().equals("USER")) {
			//create a cart for this user
			
			cart= new Cart();
			cart.setUser(user);
			assertEquals("Failed to add the address!", true, userDAO.addCart(cart));	
			//add a shipping address for this user
			
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Krissh Nagar");
			address.setAddressLineTwo("Near the hospital");
			address.setCity("CORUM");
			address.setState("Sakarya");
			address.setCountry("Turkey");
			address.setPostalCode("19100");
			//set shipping to true
			address.setShipping(true);
			//link it with the user
			address.setUserId(user.getId());
			
			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		}
		
		
	}*/
	
	/*@Test
	public void addCartTest() {
		
		user= new User();
		user.setLastName("sen");
		user.setFirstName("kadir");
		user.setEmail("kadirsen19@gmail.com");
		user.setContactNumber("5364642565");
		user.setRole("USER");
		user.setPassword("kadirsen19");
		
		
		if(user.getRole().equals("USER")) {
			//create a cart for this user
			
			cart= new Cart();
			cart.setUser(user);
			user.setCart(cart);
			
			
		}
		assertEquals("Failed to add the shipping address!", true, userDAO.addUser(user));
		
	}*/
	
	/*@Test
	public void updateCartTest() {
		
		user=userDAO.getUserByEmail("kadirsen19@gmail.com");
		
		cart=user.getCart();
		
		cart.setGrandTotal(55555);
		cart.setCartLines(2);
		
		
		assertEquals("Failed to add the shipping address!", true, userDAO.updateCart(cart));
		
	}*/
	
	/*@Test
	public void testAddress() {
		
		// we need to add a user
		user= new User();
		user.setLastName("sen");
		user.setFirstName("kadir");
		user.setEmail("kadirsen19@gmail.com");
		user.setContactNumber("5364642565");
		user.setRole("USER");
		user.setPassword("kadirsen19");
		
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
		
		//we are going to add the address
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near the school");
		address.setCity("CORUM");
		address.setState("Sakarya");
		address.setCountry("Turkey");
		address.setPostalCode("19100");
		address.setBilling(true);
		
		address.setUser(user);
		
		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
		//we are also going to add the shipping address
		
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near the hospital");
		address.setCity("CORUM");
		address.setState("Sakarya");
		address.setCountry("Turkey");
		address.setPostalCode("19100");
		//set shipping to true
		address.setShipping(true);
		//link it with the user
		address.setUser(user);
		
		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		
	}*/
	
	
	/*@Test
	public void addAddressTest() {
		
		user=userDAO.getUserByEmail("kadirsen19@gmail.com");
		
		address = new Address();
		address.setAddressLineOne("mimarsinan");
		address.setAddressLineTwo("Near the museum");
		address.setCity("CORUM");
		address.setState("yenidogan");
		address.setCountry("Turkey");
		address.setPostalCode("19100");
		//set shipping to true
		address.setShipping(true);
		//link it with the user
		address.setUser(user);
		
		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		
	}*/
	@Test
	public void getAddress() {
		
		user=userDAO.getUserByEmail("kadirsen19@gmail.com");
		
		assertEquals("Failed to fetch the list of address and size does not match!",2, 
				userDAO.listShippingAddress(user).size());
		
		assertEquals("Failed to fetch the billing address and size does not match!","CORUM", 
				userDAO.getBillingAddress(user).getCity());
		
	}
	
	
}
