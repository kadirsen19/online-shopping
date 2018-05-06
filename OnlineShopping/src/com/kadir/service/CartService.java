package com.kadir.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadir.dao.CartLineDAO;
import com.kadir.dao.ProductDAO;
import com.kadir.model.Cart;
import com.kadir.model.CartLine;
import com.kadir.model.Product;
import com.kadir.registerModel.UserModel;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private static ProductDAO productDAO;
	
	//returns the cart of the user who has logged in
	private Cart getCartOfUser() {
		
		return ((UserModel)httpSession.getAttribute("userModel")).getCart();
	}
	public List<CartLine> getCartLines(){
		
		return cartLineDAO.listCartLine(this.getCartOfUser().getId());
	}
	public String updateCartLine(int cartLineId, int count) {
	
		//fetch the cart line
		CartLine cartLine= cartLineDAO.getCartLineById(cartLineId);
		if(cartLine == null) {
			return "result= error";
		}
		else {
			
			Product product= cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			
			if(product.getQuantity() <= count) {
				count=product.getQuantity();
			}
			
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice()*count);
			cartLineDAO.updateCartLine(cartLine);
			
			Cart cart= this.getCartOfUser();
			cart.setGrandTotal(cart.getGrandTotal()- oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			return "result=updated";
		}
		
		
	}
	public String deleteCartLine(int cartLineId) {
		
		CartLine cartLine = cartLineDAO.getCartLineById(cartLineId);
		if(cartLine==null) {
			return "result=error";
		}else {
			//update the cart
			Cart cart = this.getCartOfUser();
			cart.setGrandTotal(cart.getGrandTotal()-cartLine.getTotal());
			cart.setCartLines(cart.getCartLines()-1);
			cartLineDAO.updateCart(cart);
			//remove
			cartLineDAO.deleteCartLine(cartLine);
			return "result=delete";
		}
		
		
	}
	
}
	

