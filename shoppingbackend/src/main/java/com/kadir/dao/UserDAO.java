package com.kadir.dao;

import java.util.List;

import com.kadir.model.Address;
import com.kadir.model.Cart;
import com.kadir.model.User;

public interface UserDAO {

	boolean addUser(User user);
	User getUserByEmail(String email);
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	boolean updateCart(Cart cart);
	
}
