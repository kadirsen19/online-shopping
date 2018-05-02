package com.kadir.dao;

import java.util.List;

import com.kadir.model.Cart;
import com.kadir.model.CartLine;

public interface CartLineDAO {

	
	public CartLine getCartLineById(int id);
	
	public boolean addCartLine(CartLine cartLine);
	public boolean updateCartLine(CartLine cartLine);
	public boolean deleteCartLine(CartLine cartLine);
	public List<CartLine> listCartLine(int cartId);
	
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId ,int productId);
	
	boolean updateCart(Cart cart);
}
