package com.kadir.dao;

import java.util.List;

import com.kadir.model.Address;
import com.kadir.model.Cart;
import com.kadir.model.User;

public interface UserDAO {

	boolean addUser(User user);
	User getUserByEmail(String email);
	boolean addAddress(Address address);
	/*alternative
	Address getBillingAddress(int uderId);
	List<Address> listShippingAddress(int uderId);
	*/
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	boolean updateCart(Cart cart);
	
}
